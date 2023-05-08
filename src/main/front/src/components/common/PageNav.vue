<template>
    <b-container class="pageNav">
        <b-row>
            <b-col class="text-start">
                <a id="prePage" @click="pageChange(currentPage - 1)"><font-awesome-icon :icon="['fas', 'arrow-left-long']" /></a>
                 <label for="prePage" class="p-2">Previous</label>
            </b-col>
            <b-col class="col-6">
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
        'currentPage', 'pageChange', 'totalPage'
    ],
    data() {
        return {
        }
    },
    methods: {
        onPageChange() {

        }
    },
    computed: {
        
    },
}
</script>

<style croped>

</style>