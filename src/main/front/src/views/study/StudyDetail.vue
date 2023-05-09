<template>
    <div class="container w-75 mt-5 mb-3">
        <div class="category mb-3">
            <text :class="form.category == 'files' ? 'thisCategory':'' ">자료실</text>
             / 
            <text :class="form.category == 'video' ? 'thisCategory':'' " >교육</text>
        </div>
        <b-container class="justify-content-start text-start">
            <h5>
                {{ form.writer }}
            </h5>
            {{ form.writeDate }} <font-awesome-icon :icon="['fas', 'eye']" /> {{ form.view }}
            <h2 class="mt-3 mb-5 fw-bold">
                {{ form.title }}
            </h2>
            <div v-html="form.contents"></div>
            <hr class="my-5">
        </b-container>
    </div>
</template>

<script>
export default{
    name : "StudyDetail",
    data() {
        return {
            form : {
                title : '',
                contents : '',
                writer : '',
                writeDate : '',
                view : 0,
                heart : 0,
            }
        }
    },
    methods: {
        studyRead(num){
            this.axios.get('/api/studyDetail',{
                params : {
                    num : num,
                }
            })
            .then((response)=>{
                this.form = response.data;
            })
            .catch((error)=>{console.log(error)})
        }
    },
    mounted() {
        const studyNum = this.$route.params.num;
        this.studyRead(studyNum);
    },
    created() {
    
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
    color : rgb(52, 152, 219);
}

blockquote {
    background-color: skyblue;
    margin : 10px;
}

</style>