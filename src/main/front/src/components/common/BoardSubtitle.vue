<template>
    <div>
        <b-container class="subtitle w-max rounded p-3 px-5 mb-3">
                <b-row>
                    <b-col col="8" class="text-start">
                        <div>
                            <label class="fs-1 fw-bold">
                                {{subtitle}}
                            </label>
                        </div>
                        <div class="d-none d-lg-block">
                            <label>
                                {{ labelText }}
                            </label>
                        </div>
                    </b-col>
                    <b-col col="2" class="text-end d-none d-md-block">
                        <img :src="logoPath" class="subtitle-icon">
                    </b-col>
                </b-row>
        </b-container> 
    </div>
</template>


<script>
export default{
    name:'board-subtitle',
    props:{
        subtitle : String,
        labelText : String,
        logoPath : String,
    },
    data() {
        return {

        }
    },
}
</script>

<style scoped>
.subtitle{
    background-color: rgb(224, 224, 224);
    width: 
}
.subtitle-icon{
    width: 100px;
}

</style>