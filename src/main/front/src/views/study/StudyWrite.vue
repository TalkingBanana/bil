<template>
  <b-container class="w-50">
    <subtitle :logoPath="logoPath" :labelText="labelText" :subtitle="subtitle"/>
    <b-form @submit="submit()">
        <b-form-input placeholder="제목을 작성해주세요" class="my-5" v-model="form.title" ref="title"></b-form-input>
            <b-form-select
            v-model="form.category"
            :options="categories"
            required
            class="mb-5"
            ref="categorySelect"
            ></b-form-select>
        <!-- <ckeditor :editor="Editor" v-model="form.contents" :config="editorConfig" class="ckeditor"></ckeditor> -->
        <ckeditor :editor="editor" :config="editorConfig" v-model="form.contents"></ckeditor>
        <b-container class="my-3 justify-content-md-end d-md-flex">
            <b-button class="" type="reset">취소</b-button>
            <b-button type="submit" class="btn-custom ms-2">등록</b-button>
        </b-container>
    </b-form>
  </b-container>
</template>

<script>
  import Editor from 'ckeditor5-custom-build/build/ckeditor';
  import Subtitle from '../../components/common/BoardSubtitle.vue';
  import router from '@/router';


  export default {
    components: { Subtitle },
      name: 'StudyWrite',
      data() {
          return {
            logoPath :require('@/assets/imgs/study/study-icon.png'),
            labelText : "좋은 질문과 답변으로 동료의 시간을 아껴주세요",
            subtitle : "교육",
            editor: Editor,
            editorConfig: {
            // The configuration of the editor.
                simpleUpload: {
                    // 업로드 URL
                    uploadUrl: '/api/knowledgeUpload',
                    // 헤더 옵션 (선택사항)
                    headers: {
                    'X-CSRF-TOKEN': 'CSRF_TOKEN_VALUE',
                    },
                    method : 'POST'
                },
                mediaEmbed: {
                    previewsInData: true
                },
              },
              categories:[
                {text:'태그를 선택해주세요',value:null},
                {text:'강의',value:'video'},
                {text:'자료실',value:'files'}
              ],
              form:{
                  title:'',
                  category : '',
                  contents : ''
              }
          };
      },
      methods: {
        submit(){
            if(this.form.category==null){
                alert("태그를 선택해주세요");
                this.$refs.categorySelect.focus()
                return;
            }
            if(this.form.title == null || this.form.title == ""){
                alert("제목을 입력해주세요");
                this.$refs.title.focus();
                return;
            }
            if(this.form.contents == null || this.form.contents == ""){
                alert("내용을 입력하세요");
                return;
            }
            const form = new FormData();
            form.append("title",this.form.title);
            form.append("category",this.form.category);
            form.append("contents",this.form.contents);

            this.axios.post('/api/insertStudy',form,{
                headers:{
                    "Content-type": "multipart/form-data"
                }
            })
            .then(
                alert("작성되었습니다."),
                router.push({
                    name:"StudyBoard"
                })
            )
            .catch((error)=>{console.log(error)})
        }
      },
  }
</script>

<style scoped>
.btn-custom{
  --bs-btn-bg:rgb(52, 152, 219) !important;
  --bs-btn-border-color : null !important;
}

.btn-custom:hover{
  background-color: rgb(126, 186, 226) !important;
}


</style>