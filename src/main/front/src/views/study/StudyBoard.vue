<template>
  <div>
    <div id="knowledge-board" class="container-lg w-50">
        <subtitle :logoPath="logoPath" :labelText="labelText" :subtitle="subtitle"/>
    </div>
  </div>
</template>

<script>
import Subtitle from '../../components/common/BoardSubtitle.vue';
  export default {
  components: { Subtitle },
      name: 'StudyBoard',
      data() {
          return {
            logoPath :require('@/assets/imgs/study/study-icon.png'),
            labelText : "좋은 질문과 답변으로 동료의 시간을 아껴주세요",
            subtitle : "교육",
          };
      },
      mounted() {
        
      },
      methods: {
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