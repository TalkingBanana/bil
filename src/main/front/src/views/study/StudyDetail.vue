<template>
    <div class="container w-75 mt-5 mb-3">
        <div class="category mb-3">
            <text :class="form.category == 'files' ? 'thisCategory':'' ">자료실</text>
             / 
            <text :class="form.category == 'video' ? 'thisCategory':'' " >교육</text>
        </div>

        <!-- 게시글 내용 -->
        <b-container class="justify-content-start text-start">
            <h5>
                {{ form.writer }}
            </h5>
            {{ form.writeDate }} <font-awesome-icon :icon="['fas', 'eye']" /> {{ form.view }}
            <h2 class="mt-3 mb-5 fw-bold">
                {{ form.title }}
            </h2>
            <div v-html="form.contents"></div>

            <b-container class="ms-auto text-end">
                <font-awesome-icon :icon="['fas', 'thumbs-up']" /> 
                <text class="fw-bold ms-2">
                    {{ form.heart }}
                </text>
            </b-container>
            
            <!-- 첨부파일 다운로드 -->
            <b-container v-if="this.form.fileYn" class="my-5">
                <text class="text-body d-block mb-1">첨부파일</text>
                <b-button @click="download">
                    {{ form.fileYn }} <font-awesome-icon class="mx-1" :icon="['fas', 'download']" />
                </b-button>
            </b-container>

            <!-- 댓글 정렬 -->
            <hr class="my-5">
            <b-container class=" d-flex mb-4">
                <text class="text-body">
                    {{ form.comments }} 개의 댓글
                </text>
                <div class="dropdown text-sm ms-auto">
                <b-button  class="btn-custom-order dropdown-toggle" :text="this.order"  data-bs-toggle="dropdown">
                  <font-awesome-icon :icon="['fas', 'arrow-down-wide-short']" />
                  {{ this.order }}
                </b-button >
                <ul class="dropdown-menu dropdown-menu-end">
                  <li><a class="dropdown-item" >최신순</a></li>
                  <li><a class="dropdown-item" >추천순</a></li>
                </ul>
              </div>
            </b-container>
            
            <!-- 댓글 작성-->
            <b-container class="border rounded mb-5"> 
                <b-form class="mt-3">
                    <b-form-textarea placeholder="댓글을 작성해주세요"></b-form-textarea>
                    <b-container class="d-flex">
                        <b-button class="my-3 ms-auto btn-custom">
                          댓글쓰기
                        </b-button>
                    </b-container>
                </b-form>
            </b-container>

            <!-- 게시글의 댓글 -->
            <ul class="nav flex-column">
                <li v-for="data in commentList" :key="data" class="mb-3 commentList py-3 flex-column nav-item border-bottom">
                    <div >
                        <h5>{{ data.writer }}</h5>
                        <text class="text-body">{{ data.writeDate }}</text>
                        <b-container class="ms-auto text-end">
                        <font-awesome-icon :icon="['fas', 'thumbs-up']"/> 
                            <text class="fw-bold ms-2">
                                {{ data.heart }}
                            </text>
                        </b-container>
                    <div class="my-3">
                        {{ data.contents }}
                    </div>
                    <button class="bg-body border-0 text-black-50 fw-bold" data-bs-toggle="collapse"
                    :data-bs-target='"#replyComment"+data.num' aria-expanded="false"
                    >댓글 쓰기</button>
                    <div class="collapse " :id='"replyComment"+data.num'>
                        <div class="border-start p-3">
                            <ckeditor :editor="editor" v-model="commentForm.contents" :config="editorConfig"></ckeditor>
                            <div class="mt-3  d-flex">
                                <span class="ms-auto">
                                    <b-button >취소</b-button> <b-button class="btn-custom">댓글 쓰기</b-button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                </li>
            </ul>



        </b-container>
    </div>
</template>

<script>
import Editor from 'ckeditor5-custom-build/build/ckeditor';
const token = "Bearer " + localStorage.getItem('user_token');


export default{
    name : "StudyDetail",
    data() {
        return {
            form : {
                title : '',
                contents : 0,
                writer : '',
                writeDate : '',
                view : 0,
                heart : 0,
                fileYn : null,
                fileDir : 'C:/bil-storage/',
                commentList : [],
            },
            order : '최신순',
            commentForm:{
                comments:'',
                writer:'',
                writeDate:'',
                heart:0,
            },
            editor: Editor,
            editorConfig: {
                // The configuration of the editor.
                simpleUpload: {
                    // 업로드 URL
                    uploadUrl: '/api/studyUpload',
                    // 헤더 옵션 (선택사항)
                    headers: {
                      'Authorization' : token,
                    },
                    method : 'POST'
                },
                mediaEmbed: {
                    previewsInData: true
                },
              },
        }
    },
    methods: {
        studyRead(num){ // 게시글 데이터 조회
            this.$axios.get('/api/studyDetail',{
                params : {
                    num : num,
                }
            })
            .then((response)=>{
                this.form = response.data;
            })
            .catch((error)=>{console.log(error)})
        },
        download(){
            const filePath = this.form.fileYn;
            this.$axios.get('/api/fileDownload',{
                params : {
                    path : filePath
                },
                responseType : "blob",
            })
            .then((response)=>{
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href=url
                link.setAttribute('download',this.form.fileYn);
                document.body.appendChild(link);
                link.click();
            }
            )
            .catch((error)=>{console.log(error)})
        },
        getCommentList(){
            const num = this.$route.params.num;
            this.$axios.get('/api/getCommentList',{
                params:{
                    num : num,
                    category : 'study'
                }
            })
            .then( (response)=>{
                this.commentList = response.data;
                console.log(this.commentList)
              }
            )
            .catch((error)=>{console.log(error)})
        },

    },
    mounted() {
        const studyNum = this.$route.params.num;
        this.studyRead(studyNum);
        this.getCommentList();
    },
    created() {
        const studyNum = this.$route.params.num;
        this.studyRead(studyNum);
        this.getCommentList();   
    },
}

</script>

<style scoped>
.category{
    align-items: center;
    display: flex;
}
.category::before{
    line-height: 0px;
    height: 1px;
    background : black;
    margin : 0px 10px;
    flex-grow: 1;
    content : "";
}
.category::after{
    line-height: 0px;
    height: 1px;
    background : black;
    margin : 0px 10px;
    flex-grow: 6;
    content : "";
}

.thisCategory{
    color : #3498db;
}

blockquote {
    background-color: skyblue;
    margin : 10px;
}

.btn-custom{
  --bs-btn-bg:#3498db !important;
  --bs-btn-border-color : null !important;
}
.btn-custom:hover{
  background-color: #7ebae2 !important;
}


</style>