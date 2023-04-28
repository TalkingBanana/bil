import { createApp } from 'vue'
import App from './App.vue'
import axios from "axios";
import router from "./router";
import BootstrapVue3 from 'bootstrap-vue-3';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import './assets/css/layouts/layout.css';

axios.defaults.baseURL="http://localhost:8090";
const app = createApp(App).use(router);
app.config.globalProperties.axios = axios;
app.use(router)
.use(BootstrapVue3)
.mount('#app');