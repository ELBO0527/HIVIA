<template>
  <div>
    <!-- 회원가입 헤더 -->
    <v-form v-model="valid">
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
                  <h1>회원가입</h1>
                </div>
              </v-col>
            </v-row>
          </v-sheet>
        </v-col>
        <!-- 회원가입 내용 -->
        <v-row class="mx-24">
          <v-col cols="12" md="12">
            <div class="pa-12" justify="center" align="center">
              <h2>정보를 입력해주세요</h2>
            </div>
          </v-col>
          <v-col cols="12" md="12">
            <v-sheet height="360">
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>아이디</h4>
                  </v-sheet>
                </v-col>
                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="사용될 아이디를 입력하세요."
                      :rules="nameRules"
                      :counter="10"
                      solo
                      dense
                      v-model="username"
                    ></v-text-field>
                  </v-row>
                </v-col>
              </v-row>
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>E-mail</h4>
                  </v-sheet>
                </v-col>
                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="이메일을 입력하세요."
                      :rules="emailRules"
                      solo
                      dense
                      type="email"
                      v-model="email"
                    ></v-text-field>
                    <!--<v-list-item-subtitle>*답변 등록 시 연락받을 이메일 주소를 입력하세요.</v-list-item-subtitle>-->
                  </v-row>
                </v-col>
              </v-row>
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>비밀번호</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="비밀번호를 입력하세요."
                      solo
                      dense
                      v-model="passwd"
                      type="password"
                    ></v-text-field>
                  </v-row>
                </v-col>
              </v-row>
              <!--생일 정보-->
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>생년월일</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-menu
                      v-model="menu2"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      transition="scale-transition"
                      offset-y
                      min-width="auto"
                    >
                      <template v-slot:activator="{ on, attrs }">
                        <v-text-field
                          label="생년 월일을 입력하세요."
                          solo
                          dense
                          v-model="birthday"
                          prepend-icon="mdi-calendar"
                          readonly
                          v-bind="attrs"
                          v-on="on"
                        ></v-text-field>
                      </template>
                      <v-date-picker
                        v-model="birthday"
                        @input="menu2 = false"
                      ></v-date-picker>
                    </v-menu>
                  </v-row>
                </v-col>
              </v-row>
              <!--우편번호-->
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>우편번호</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      @click="execDaumPostcode()"
                      label="우편번호(클릭시 창을 띄웁니다.)"
                      solo
                      dense
                      v-model="zipcode"
                    ></v-text-field>
                  </v-row>
                </v-col>
              </v-row>

              <!--주소 정보-->
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>주소</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="주소를 입력하세요."
                      solo
                      dense
                      v-model="addr"
                    ></v-text-field>
                  </v-row>
                </v-col>
              </v-row>
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>상세주소</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="상세 주소를 입력하세요."
                      solo
                      dense
                      v-model="addr_detail"
                    ></v-text-field>
                  </v-row>
                </v-col>
              </v-row>
              <!--핸드폰 번호-->
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>핸드폰</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="핸드폰 번호를 입력하세요."
                      solo
                      dense
                      v-model="mobile"
                    ></v-text-field>
                  </v-row>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" md="12">
                  <div class="pa-12" justify="center" align="center">
                    <v-btn
                      min-width="300"
                      color="primary"
                      @click="addNewUser()"
                    >
                      회원가입
                    </v-btn>
                    <!-- <v-alert
              dense
              type="success"
              v-model="alert"
              >
              {{}}
            </v-alert> -->
                  </div>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
        </v-row>
      </v-row>
    </v-form>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      valid: false,
      nameRules: [
        v => !!v || '이름이 필요합니다',
        v => v.length <= 10 || '이름은 10글자 이하여야합니다',
      ],
      emailRules: [v => !!v || '이메일이 필요합니다'],
      email: '',
      username: '',
      passwd: '',
      birthday: new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
        .toISOString()
        .substr(0, 10),
      mobile: '',
      balance: 0,
      zipcode: '',
      addr: '',
      addr_detail: '',
      alert: this.$store.alert,
    };
  },

  methods: {
    ...mapActions(['addUser']),
    addNewUser() {
      this.addUser({
        email: this.email,
        username: this.username,
        passwd: this.passwd,
        birthday: this.birthday,
        mobile: this.mobile,
        addr: this.addr,
        addr_detail: this.addr_detail,
        zipcode: this.zipcode,
      });
    },
    execDaumPostcode() {
      //다음 주소 API
      new window.daum.Postcode({
        oncomplete: data => {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          let fullRoadAddr = data.roadAddress; // 도로명 주소 변수
          let extraRoadAddr = ''; // 도로명 조합형 주소 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr +=
              extraRoadAddr !== ''
                ? ', ' + data.buildingName
                : data.buildingName;
          }
          // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')';
          }
          // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
          if (fullRoadAddr !== '') {
            fullRoadAddr += extraRoadAddr;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          this.zipcode = data.zonecode; //5자리 새우편번호 사용
          this.addr = fullRoadAddr;
        },
      }).open();
    },
  },
};
</script>
