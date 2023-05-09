<template>
  <div>
    <b-button @click="dataSet()">응애</b-button>
    <div id="knowledge-board" class="container-lg w-50 mb-3">
      <subtitle :logoPath="logoPath" :labelText="labelText" :subtitle="subtitle"/>
      <b-container class="w-max p-0">
        <b-nav class="p-0">
            <b-nav-item class="text-start me-auto">
              <b-button class="btn-custom" to="StudyWrite">
                  작성하기
              </b-button>
            </b-nav-item>
            <b-nav-item class="text-center">
              <b-nav class="justify-content-center">
                <b-nav-item v-for="category in categories" :key="category" @click="categoryChange(category)">
                  <span :class="category == currentCategory ? 'currentCategory' : 'categories'">
                    {{ category }}
                  </span>
                </b-nav-item>
              </b-nav>
            </b-nav-item>
            <b-nav-item class="text-end ms-auto">
              <div class="dropdown text-sm">
                <b-button  class="btn-custom-order dropdown-toggle" :text="this.order" data-bs-toggle="dropdown">
                  <font-awesome-icon :icon="['fas', 'arrow-down-wide-short']" />
                  {{ this.order }}
                </b-button >
                <ul class="dropdown-menu dropdown-menu-end">
                  <li><a class="dropdown-item" @click="orderChange('최신순')">최신순</a></li>
                  <li><a class="dropdown-item" @click="orderChange('추천순')">추천순</a></li>
                  <li><a class="dropdown-item" @click="orderChange('댓글순')">댓글순</a></li>
                  <li><a class="dropdown-item" @click="orderChange('조회순')">조회순</a></li>
                </ul>
              </div>
            </b-nav-item>
        </b-nav>
        <hr>
        <b-nav class="nav-justified text-sm">
            <b-nav-item class="text-start me-auto">
                <font-awesome-icon :icon="['fas', 'rotate']" class="fs-5 text-dark" @click="refresh()"/>
            </b-nav-item>
            <b-nav-item class="m-auto">
              <div class="rounded-pill border border-2 p-1 min-w-100">
                <form v-on:submit.prevent="search()">
                  <font-awesome-icon :icon="['fas', 'magnifying-glass']" class="text-black" />
                  <input id="knowledge-input-group" v-model="this.keyword"  class="ms-3 border-0 w-75" :placeholder="inputPlaceHolder"/>
                </form>
              </div>
            </b-nav-item>
            <b-nav-item class="text-end ms-auto">
              <label class="text-black">
                {{ currentPage }} / {{totalPage }} 페이지
              </label>  
                  <font-awesome-icon @click="pageChange(currentPage-1)"  :icon="['fas', 'arrow-left-long']" class="mx-2 fs-5 text-dark"/>
                  <font-awesome-icon @click="pageChange(currentPage+1)" :icon="['fas', 'arrow-right-long']" class="fs-5 text-dark"/>
            </b-nav-item>
        </b-nav>
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
                {{ board.korCategory }}
              </b-button>
            </b-col>
          </b-row>
          <hr>
        </b-container>
        <page-nav :currentPage="currentPage" :totalPage="totalPage" :pageChange="pageChange"></page-nav>
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
              "자료실","강의", "전체"
            ],
            currentCategory : '전체',
            inputPlaceHolder : '교육 내에서 검색',
            totalItems : 0,
            totalPage : 0,
            currentPage : 1,
            boardList : [],
            order : '최신순',
            keyword : '',
          };
      },
      mounted() {
        this.search()
      },
      methods: {
        dataSet(){
          this.$axios.get('/api/insertStudy')
          .then((response)=>{
            console.log(response)
          })
          .catch((error)=>{
            console.log(error)
          })
          ;
        },
        getStudyList(){
          this.$axios.get('/api/studyList',{
            params:{
              page : this.currentPage,
              category : this.currentCategory,
              keyword: this.keyword,
              order : this.order,
            }
          })
          .then((response)=>{
            this.boardList = response.data;
          })
          .catch((error)=>{console.log(error)})
        },
        getStudyTotal(){
          this.$axios.get('/api/studyTotal',{
            params:{
              category : this.currentCategory,
              keyword : this.keyword,
            }           
          })
          .then((response)=>{
            this.totalItems = response.data;
            this.totalPage = Math.ceil(this.totalItems/10);
          })
          .catch((error)=>{
            console.log(error)
          })
        },
        pageChange(val){
          if(val<=0){
            return;
          }
          if(val>this.totalPage){
            return;
          }
          this.currentPage = val;
          this.getStudyList();
        },
        categoryChange(val){
          this.currentPage = 1;
          this.currentCategory = val;
          this.search();
        },
        orderChange(val){
          this.order = val;
          this.search()
        },
        search(){
          this.currentPage=1;
          this.getStudyTotal();
          this.getStudyList();
        },
        refresh(){
          this.currentPage = 1;
          this.currentCategory = "전체";
          this.keyword = "";
          this.order = "최신순";
          this.search();
        }
      },
  }
</script>

<style scoped>
.btn-custom{
  --bs-btn-bg:rgb(52, 152, 219) !important;
  --bs-btn-border-color : null;
  background-color: rgb(52, 152, 219) !important;
}
.btn-custom:hover{
  background-color: rgb(126, 186, 226);
}

.btn-custom-order{
  --bs-btn-bg: rgb(224, 224, 224);
  --bs-btn-border-color : null;
  color : black;
}
#knowledge-input-group:focus{
  outline: none;
}
.currentCategory{
  color: rgb(52, 152, 219) !important;
}

.categories{
  color : black !important;
}
.categories:hover{
  color: rgb(52, 152, 219) !important;
  transition: 0.15s;
}
.text-dark:hover{
  color: rgb(52, 152, 219) !important;
  transition: 0.15s;
}

</style>