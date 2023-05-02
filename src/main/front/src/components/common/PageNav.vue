<template>
    <b-container class="pageNav">
        <b-row>
            <b-col class="text-start">
                <a id="prePage" @click="pageChange(currentPage - 1)"><font-awesome-icon :icon="['fas', 'arrow-left-long']" /></a>
                 <label for="prePage" class="p-2">Previous</label>
            </b-col>
            <b-col class="col-6">
                <a v-for="(paging, index) in pages" :key="index" @click="onPageChange(paging - 1)" :class="paging - 1 === currentPage ? 'currentPage' : ''">{ { paging } }</a>
            </b-col>
            <b-col class="text-end">
                <a id="nextPage" @click="pageChange(currentPage + 1)"><font-awesome-icon :icon="['fas', 'arrow-right-long']" /></a>
                  <label for="nextPage" class="p-2">Next</label>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
export default {
    name : 'PageNav',
    props:[
        'currentPage', 'totalPage', 'pageChange'
    ],
    data() {
        return {
        }
    },
    methods: {
        onPageChange(val) {
            if (val < 0) {
                // alert('첫 페이지입니다.');
                return;
            }
            if (val >= this.totalPages) {
                // alert('마지막 페이지입니다.');
                return;
            }
        }
    },
    computed: {
        pages: function() {
            const list = [];
            for (let index = this.startPage; index <= this.endPage; index += 1) { list.push(index); }
            return list;
        },
        startPage() {
            return parseInt(this.currentPage / 10) * 10 + 1;
        },
        endPage() {
            let lastPage = parseInt(this.currentPage / 10) * 10 + 10;
            return lastPage <= this.totalPages ? lastPage : this.totalPages;
        }
    },
}
</script>

<style croped>

</style>