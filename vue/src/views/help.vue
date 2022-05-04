<template>
  <div>
    <!-- 문의하기 헤더 -->
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
                <h1>문의하기</h1>
              </div>
            </v-col>
          </v-row>
        </v-sheet>
      </v-col>
      <v-form v-model="valid">
        <v-col cols="12" md="12">
          <v-tabs>
            <v-tab>
              문의 하기
            </v-tab>
            <v-tab to="/help-list">
              문의 내용 보기
            </v-tab>
          </v-tabs>
        </v-col>
        <!-- 문의하기 내용 -->
        <v-row class="mx-24">
          <v-col cols="12" md="12">
            <div class="pa-12" justify="center" align="center">
              <h2>양식을 작성해주세요</h2>
            </div>
            <v-sheet height="120">
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>이메일 주소</h4>
                  </v-sheet>
                </v-col>
                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="이메일 주소를 입력하세요."
                      solo
                      dense
                      full-width="200"
                    ></v-text-field>
                    <v-list-item-subtitle
                      >*답변 등록 시 연락받을 이메일 주소를
                      입력하세요.</v-list-item-subtitle
                    >
                  </v-row>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
          <!--구분선-->
          <v-col cols="12" md="12">
            <v-sheet height="120">
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>휴대폰 번호</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="'-'을 제외한 휴대폰 번호를 입력하세요."
                      solo
                      dense
                    ></v-text-field>
                    <v-list-item-subtitle
                      >*'-'을 제외한 휴대폰 번호를
                      입력하세요.</v-list-item-subtitle
                    >
                  </v-row>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
          <v-col cols="12" md="12">
            <v-sheet height="120">
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>문의 유형</h4>
                  </v-sheet>
                </v-col>
                <v-col class="d-flex" cols="12" sm="5">
                  <v-row>
                    <v-select
                      :items="items"
                      label="문의 유형"
                      hide-details
                      solo
                    ></v-select>
                    <v-select
                      :items="items"
                      label="ass"
                      solo
                      hide-details
                      class="px-4"
                    ></v-select>
                    <v-list-item-subtitle class="pt-4"
                      >*문의 유형을 선택하세요</v-list-item-subtitle
                    >
                  </v-row>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
          <v-col cols="12" md="12">
            <v-sheet height="120">
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>제목</h4>
                  </v-sheet>
                </v-col>

                <v-col class="d-flex" cols="12" sm="3">
                  <v-row>
                    <v-text-field
                      label="제목을 입력하세요."
                      solo
                      dense
                    ></v-text-field>
                    <v-list-item-subtitle
                      >*제목을 입력하세요</v-list-item-subtitle
                    >
                  </v-row>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
          <v-col cols="12" md="12">
            <v-sheet height="280">
              <v-row>
                <v-col class="pa-4" cols="3" md="5">
                  <v-sheet align="center" justify="center">
                    <h4>내용</h4>
                  </v-sheet>
                </v-col>
                <v-col class="d-flex" cols="12" sm="5">
                  <v-textarea solo name="input-7-4" label="내용"></v-textarea>
                </v-col>
              </v-row>
              <v-row>
                <v-col align="center" justify="center">
                  <v-btn color="primary"> 문의하기</v-btn>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
        </v-row>
      </v-form>
    </v-row>
  </div>
</template>
