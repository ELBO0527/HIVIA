<template>
  <div>
    <!-- 로그인 헤더 -->
    <v-row>
      <v-col cols="12" md="12">
        <v-sheet color="grey lighten-3" height="280">
          <v-row align="center" justify="center" class="fill-height">
            <v-col class="pa-3" cols="6" md="3">
              <div
                color="grey lighten-3"
                align="center"
                justify="center"
                width="420"
              >
                <h1>로그인</h1>
              </div>
            </v-col>
          </v-row>
        </v-sheet>
      </v-col>
      <v-col cols="12" md="12"> </v-col>
    </v-row>

    <!-- 로그인 내용 -->
    <v-row>
      <v-col cols="12">
        <div class="mb-6" align="center">
          <h2>정보를 입력해주세요</h2>
        </div>
        <v-row class="my-6" justify="center" align="center">
          <v-col class="mr-md-3" cols="3" sm="1" align="center">
            <h4>아이디</h4>
          </v-col>
          <v-col cols="3" align="center">
            <v-text-field
              label="아이디를 입력하세요."
              solo
              dense
              full-width="200"
              v-model="userId"
              hide-details="auto"
            ></v-text-field>
            <!--<v-list-item-subtitle>*답변 등록 시 연락받을 이메일 주소를 입력하세요.</v-list-item-subtitle>-->
          </v-col>
        </v-row>
      </v-col>

      <v-col cols="12">
        <v-row justify="center">
          <v-col class="mr-md-3" cols="3" md="1" sm="1" align="center">
            <h4>비밀번호</h4>
          </v-col>

          <v-col cols="3" align="center">
            <v-text-field
              label="비밀번호를 입력하세요."
              solo
              dense
              type="password"
              full-width="200"
              v-model="passwd"
              hide-details="auto"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <!--버튼-->
    <v-row class="my-12" justify="center" align="center">
      <v-col cols="2" justify="center" align="center">
        <v-btn min-width="300" color="primary" @click="loginSubmit()">
          로그인
        </v-btn>
      </v-col>
      <div>
        <v-img
          max-height="40"
          min-width="300"
          @click="kakaoLoginBtn()"
          src="../assets/kakao_login_medium_wide.png"
        ></v-img>
      </div>
    </v-row>
    <v-divider class="mt-12"></v-divider>
    <v-row justify="center">
      <v-col class="mt-4" cols="4" justify="center" align="center">
        <v-btn disabled text color="black">
          <strong>아직 회원이 아니신가요?</strong></v-btn
        >
        <v-btn :disabled="loading" color="blue" text dark to="/signup">
          <strong>회원가입</strong></v-btn
        >
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      id: '',
      passwd: '',
      loading: false,
    };
  },

  methods: {
    loginSubmit() {
      let saveData = {
        id: this.userId,
        passwd: this.passwd,
      };
      this.$store
        .dispatch('doLogin', saveData)
        .then(() => {
          this.$router.push('/');
        })
        .catch(err => {
          this.errorMessage = err.response.data.errormessage;
          console.log(id, passwd);
          alert(err.response.data.msg);
        });
    },

    async kakaoLoginBtn() {
      const response = await axios.get('/social/login/')
          const params = {redirectUri: "http://localhost:3000/signin"}
          console.log(response.data);
          window.Kakao.Auth.authorize(params);
    },
  },
  mounted(){    
    const check = window.location.href.includes("?") ? '1' : '0'
    console.log(check)
    if(check == 1){
      let code = new URL(window.location.href).searchParams.get('code');
      axios.get('http://localhost:8888/signin',{params: {code : code}})
          .then((response) => {
            console.log(response.data.data);
            axios.defaults.headers.common['X-AUTH-TOKEN'] = response.data.data;
            //this.$store.dispatch('socialId',id)
            this.$store
            .dispatch('socialLogin',response.data.data)
            .then(() => {
          this.$router.push('/');
        })
        .catch(err => {
          this.errorMessage = err.response.data.errormessage;
          console.log(id, passwd);
          alert(err.response.data.msg);
        });
          //this.$router.push('/');
        })
        .catch(err => {
          this.errorMessage = err.response.data.errormessage;
          console.log(id, passwd);
          alert(err.response.data.msg);
        });
    }
    }
};
</script>
