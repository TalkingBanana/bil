import { createApp } from 'vue'
import App from './App.vue'
import axios from "axios";
import router from "./router";
import BootstrapVue3 from 'bootstrap-vue-3';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import './assets/css/layouts/layout.css';
import CKEditor from "@ckeditor/ckeditor5-vue";

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { fas } from '@fortawesome/free-solid-svg-icons'

import { far } from '@fortawesome/free-regular-svg-icons';

import { fab } from '@fortawesome/free-brands-svg-icons';


/* add icons to the library */
library.add(fas, far, fab)


axios.defaults.baseURL="http://localhost:8090";
const app = createApp(App).use(router);
app.config.globalProperties.axios = axios;
app.use(router)
.use(BootstrapVue3)
.use(CKEditor)
.component('font-awesome-icon', FontAwesomeIcon)
.mount('#app');