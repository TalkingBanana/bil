<template>
    <b-nav class="pageNav fs-5 fw-semibold">
        <b-nav-item class="me-auto" :class="currentPage == 1 ? 'cursor-default':''">
            <a id="prePage" @click="pageChange(1)" :class="currentPage == 1 ? 'beginNav':'prePage'"><font-awesome-icon :icon="['fas', 'arrow-left-long']" />
            <label class="p-2">Start</label>
            </a>
        </b-nav-item>
        <b-nav-item class="w-50">
            <ul class="nav justify-content-center">
                <li class="nav-item" v-for="index in pages" :key="index">
                    <a class="nav-link" @click="pageChange(index)" :class="index == currentPage ? 'currentPage' : 'text-body'">{{ index }}</a>
                </li>
            </ul>
        </b-nav-item>
        <b-nav-item class="ms-auto flex-sm-column" :class="currentPage == totalPage ? 'cursor-default':''">
            <a id="nextPage" @click="pageChange(this.totalPage)" :class="currentPage == totalPage ? 'endNav':'nextPage'">
            <label class="p-2" >End</label>
            <font-awesome-icon :icon="['fas', 'arrow-right-long']" />
            </a>
        </b-nav-item>
    </b-nav>
</template>

<script>
export default {
    name : 'PageNav',
    props:{
        currentPage:{
            type : Number,
            default : 1,
            require : false,
        },
        pageChange:{},
        totalPage:{
            require: false,
        },
        pageSize:{
            type : Number,
            default : 10,
            require : false,
        }
    },
    data() {
        return {}
    },
    methods: {
        onPageChange() {

        }
    },
    computed: {
        startPage : function(){
            var result =  this.currentPage - 2;
            if(result <= 0){
                result = 1;
            }
            return result;
        },
        pages : function(){
            const list = [];
            for(let index = this.startPage; index <= this.endPage; index++){
                list.push(index);
            }
            return list;
        },
        endPage() {
            let result = this.currentPage+2;
            if(result>=this.totalPage){
                result = this.totalPage;
            }
            return result;
        }
    },
}
</script>

<style scoped>
.currentPage{
    color : rgb(52, 152, 219) !important;
}
label:hover{
    cursor: pointer;
}
.text-body:hover{
    color : rgb(52, 152, 219) !important;
}
.prePage , .nextPage{
    color : black;
}
.beginNav, .endNav{
    color : rgb(224, 224, 224);
}
.prePage:hover, .nextPage:hover{
    color : rgb(52, 152, 219) !important;
    transition: color .15s
}

.beginNav:hover, .endNav:hover{
    color : rgb(224, 224, 224);
}

.cursor-default:hover{
    cursor : default !important;
}
.cursor-default{
    cursor: default;
}

</style>