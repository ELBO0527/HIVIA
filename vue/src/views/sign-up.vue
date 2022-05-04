<template>
  <div>
    <!-- 회원가입 헤더 -->
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
          <v-sheet height="120">
            <v-row>
              <v-col class="pa-4" cols="3" md="5">
                <v-sheet align="center" justify="center">
                  <h4>아이디</h4>
                </v-sheet>
              </v-col>
              <v-col class="d-flex" cols="12" sm="3">
                <v-row>
                  <v-text-field
                    label="아이디를 입력하세요."
                    solo
                    dense
                    full-width="200"
                  ></v-text-field>
                  <!--<v-list-item-subtitle>*답변 등록 시 연락받을 이메일 주소를 입력하세요.</v-list-item-subtitle>-->
                </v-row>
              </v-col>
            </v-row>
          </v-sheet>
        </v-col>
        <v-col cols="12" md="12">
          <v-sheet height="360">
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
                  ></v-text-field>
                </v-row>
              </v-col>
            </v-row>
            <!--비밀번호 확인-->
            <v-row>
              <v-col class="pa-4" cols="3" md="5">
                <v-sheet align="center" justify="center">
                  <h4>비밀번호 확인</h4>
                </v-sheet>
              </v-col>

              <v-col class="d-flex" cols="12" sm="3">
                <v-row>
                  <v-text-field
                    label="비밀번호를 다시 한 번 입력하세요."
                    solo
                    dense
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
                  <v-text-field
                    label="생년 월일을 입력하세요."
                    solo
                    dense
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
                  ></v-text-field>
                </v-row>
                <v-row>
                  <v-text-field
                    label="상세 주소를 입력하세요."
                    solo
                    dense
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
                  ></v-text-field>
                </v-row>
              </v-col>
              <v-col class="d-flex" cols="12" sm="3">
                <v-row>
                  <div class="pa-12" justify="center" align="center">
                    <v-btn color="primary"> 인증하기</v-btn>
                  </div>
                </v-row>
              </v-col>
            </v-row>
          </v-sheet>
        </v-col>
        <v-row>
          <v-col cols="12" md="12">
            <div class="pa-12" justify="center" align="center">
              <v-btn color="primary"> 회원가입</v-btn>
            </div>
          </v-col>
        </v-row>
      </v-row>
    </v-row>
  </div>
</template>
