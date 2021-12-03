import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

import { library as faLibrary } from '@fortawesome/fontawesome-svg-core';
import { faHome, faSearch, faCaretDown,faSyncAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'; 

// Set up FontAwesome faLibrary.add(faHome, faSearch, faPlus) Vue.component('font-awesome-icon', FontAwesomeIcon)
faLibrary.add(faHome, faSearch, faCaretDown,faSyncAlt) 
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.use(BootstrapVue)
Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
