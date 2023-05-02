<template>
  <div>
    <div id="knowledge-board" class="container-lg w-50 mb-3">
      <subtitle :logoPath="logoPath" :labelText="labelText" :subtitle="subtitle"/>
      <b-container class="w-max p-0">
        <b-container class="p-0">
          <b-row>
            <b-col class="text-start">
              <b-button class="btn-custom">작성하기</b-button>
            </b-col>
            <b-col col="5" class="text-center">
              <b-nav>
                <b-nav-item v-for="category in categories" :key="category">{{ category }}</b-nav-item>
                <b-nav-item>전체</b-nav-item>
              </b-nav>
            </b-col>
            <b-col class="text-end">
              <b-button class="btn-custom-order">
                <font-awesome-icon :icon="['fas', 'angles-down']" />
                최신순
              </b-button>
            </b-col>
          </b-row>
        </b-container>
        <hr>
        <b-container>
          <b-row>
            <b-col class="text-start fs-4">
                <font-awesome-icon :icon="['fas', 'rotate']" />
            </b-col>
            <b-col col="5">
              <div class="rounded-pill border border-2 p-1 min-w-100">
                <span class="w-25">
                  <font-awesome-icon :icon="['fas', 'magnifying-glass']" />
                </span>
                <input id="knowledge-input-group" class="ms-3 border-0 w-75" :placeholder="inputPlaceHolder"/>
              </div>
            </b-col>
            <b-col class="text-end fs-5">
                {{ currentPage }} / {{totalPage }} 페이지 
                <font-awesome-icon :icon="['fas', 'arrow-left-long']" /> <font-awesome-icon :icon="['fas', 'arrow-right-long']" />
            </b-col>
          </b-row>
        </b-container>
        <hr>
        <b-container v-for="board in boardList" :key="board">
          <b-row class="p-2">
            <b-col class="text-start">
              {{ board.writer }} ·
              {{ board.writeDate }}</b-col>
          </b-row>
          <b-row class="p-2">
            <b-col class="text-start fs-2">{{ board.title }}</b-col>
            <b-col class="text-end col-8">
              <span class="me-3">
                <font-awesome-icon :icon="['fas', 'eye']" /> {{ board.view }} 
              </span>
              <span class="me-3">
                <font-awesome-icon :icon="['fas', 'comment-dots']" /> {{ board.comments }} 
              </span>
              <span>
                <font-awesome-icon :icon="['fas', 'thumbs-up']" /> {{ board.heart }}
              </span>
            </b-col>
          </b-row>
          <b-row class="p-2">
            <b-col class="text-start">
              <b-button class="border border-dark rounded-3 p-1 text-info bg-white px-4">
                {{ board.category }}
              </b-button>
            </b-col>
          </b-row>
          <hr>
        </b-container>
        <page-nav></page-nav>
      </b-container>
  </div>
  </div>
</template>

<script>
import Subtitle from '../../components/common/BoardSubtitle.vue';
import PageNav from '../../components/common/PageNav.vue';

  export default {
  components: { Subtitle, PageNav },
      name: 'StudyBoard',
      data() {
          return {
            logoPath :require('@/assets/imgs/study/study-icon.png'),
            labelText : "좋은 질문과 답변으로 동료의 시간을 아껴주세요",
            subtitle : "교육",
            categories:[
              "자료실","강의",
            ],
            currentCategory : '',
            inputPlaceHolder : '교육 내에서 검색',
            totalPage : 0,
            currentPage : 0,
            boardList : [],
          };
      },
      mounted() {
        this.getStudyList();
      },
      methods: {
        getStudyList(){
          this.axios.get('/api/studyList',{
            params:{
              page : this.currentPage,
            }
          })
          .then((response)=>{
            console.log(response.data)
            this.boardList = response.data;
          })
          .catch((error)=>{console.log(error)})
        },
        pageChange(){
          
        },
      },
  }
</script>

<style scoped>
.btn-custom{
  --bs-btn-bg:rgb(52, 152, 219);
  --bs-btn-border-color : null;
}

.btn-custom-order{
  --bs-btn-bg: rgb(224, 224, 224);
  --bs-btn-border-color : null;
  color : black;
}
#knowledge-input-group:focus{
  outline: none;
}

</style>