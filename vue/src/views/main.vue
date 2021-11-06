<template>
  <div class="main">
      <!-- 슬라이드쇼 -->
 <v-carousel v-model="model" height="400px">
    <v-carousel-item
      v-for="(color) in colors"
      :key="color"
    >
      <v-sheet
        :color="color"
        height="100%"
        tile
      >
        <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
        </v-row>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>

<!-- 카테고리 -->
<div class="px-12 ma-12">
  <v-divider></v-divider>
</div>
  <div class="px-12 mx-12">
  <h1>인기상품</h1>
  <h4>전체보기 ></h4>
<v-container
  fluid>
   <v-card>
    <v-tabs
      background-color="primary"
      fixed-tabs
      dark
    >
      <v-tab>카테고리1</v-tab>
      <v-tab>카테고리2</v-tab>
      <v-tab>카테고리3</v-tab>
      <v-tab>카테고리4</v-tab>
      <v-tab>카테고리5</v-tab>

      <v-tab-item
        v-for="n in 5"
        :key="n"
      >
        <v-container fluid>
          <v-row>
            <v-col
              v-for="i in 4"
              :key="i"
              cols="12"
              md="3"
            >
              <v-img
                :src="`https://picsum.photos/500/300?image=${i * n * 5 + 10}`"
                :lazy-src="`https://picsum.photos/10/6?image=${i * n * 5 + 10}`"
                aspect-ratio="1.3"
                max-width="400"
                width="300"
              ></v-img>
            </v-col>
          </v-row>
        </v-container>
      </v-tab-item>
    </v-tabs>
  </v-card>
</v-container>
</div>
<!-- 그림 -->
  <div class="px-12 ma-12">
  <v-divider></v-divider>
  </div>

  <div class="px-12 mx-12">
  <h1>예시</h1>
  <h4>전체보기 ></h4>
  </div>
<v-container
  class="px-12 mx-12"
  fluid>
    <v-row justify="space-around">
    <v-col
      v-for="n in 6"
      :key="n"
      class="d-flex child-flex"
      cols="4"
    >
      <v-img
        :src="`https://picsum.photos/500/300?image=${n * 5 + 10}`"
        :lazy-src="`https://picsum.photos/10/6?image=${n * 5 + 10}`"
        aspect-ratio="1.4"
        max-height="300"
        max-width="400"
        class="grey lighten-2"
      >
        <template v-slot:placeholder>
          <v-row
            class="fill-height ma-0"
            align="center"
            justify="center"
          >
            <v-progress-circular
              indeterminate
              color="grey lighten-5"
            ></v-progress-circular>
          </v-row>
        </template>
      </v-img>
    </v-col>
  </v-row>
</v-container>

<v-container
  fluid>
  <div class="px-12 mx-12">
    <v-divider></v-divider>
    <h1>예시</h1>
    <h4>전체보기 ></h4>
  </div>
    <v-slide-group
      v-model="model"
      class="pa-4"
      active-class="success"
      show-arrows
    >
      <v-slide-item
        v-for="n in 15"
        :key="n"
        v-slot="{ active, toggle }"
      >
        <v-card
          :color="active ? undefined : 'grey lighten-1'"
          class="ma-4"
          height="350"
          width="350"
          @click="toggle"
        >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
            <v-scale-transition>
              <v-icon
                v-if="active"
                color="white"
                size="48"
                v-text="'mdi-close-circle-outline'"
              ></v-icon>
            </v-scale-transition>
          </v-row>
        </v-card>
      </v-slide-item>
    </v-slide-group>
</v-container>

  <div>
  </div>
 <!--footer -->
   <v-card>
     <v-footer
    dark
    padless
  >
    <v-card
      flat
      tile
      class="indigo lighten-1 white--text text-center"
    >
      <v-card-text>
        <v-btn
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text class="white--text pt-0">
        Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>ItDesk</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>
