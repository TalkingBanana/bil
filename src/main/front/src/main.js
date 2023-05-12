import { createApp } from 'vue'
import App from './App.vue'
import axios from './utils/axios';
import router from "./router";
import './assets/css/layouts/layout.css';
import BootstrapVue3 from 'bootstrap-vue-3';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import CKEditor from "@ckeditor/ckeditor5-vue";
import store from './vuex/store'

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { fas } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons';
import { fab } from '@fortawesome/free-brands-svg-icons';


import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

/* add icons to the library */
library.add(fas, far, fab)


axios.defaults.baseURL="http://localhost:8090";
const app = createApp(App).use(router).use(router);
app.config.globalProperties.$axios = axios
app.config.globalProperties.$store = store

const options = {
    confirmButtonColor: '#41b882',
    cancelButtonColor: '#ff7674',
  };

app.use(router)
.use(BootstrapVue3)
.use(CKEditor)
.use(VueSweetalert2, options)
.component('font-awesome-icon', FontAwesomeIcon)
.use(store)
.mount('#app');