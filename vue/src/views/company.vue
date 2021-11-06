<template>
  <div
  align="center">

  <h1 style="color:blue">IT</h1>
  <h1 style="color:green">Desk</h1>

  <v-container>
    <v-row>
      <!-- col1 -->
      <v-col
        class="d-flex"
        cols="8"
        md="4"
      >
        <v-sheet
          class="d-flex"
          color="grey lighten-3"
          height="424"
        >
          <sheet-footer>
            #1: (3r x 2c)d
          </sheet-footer>
        </v-sheet>
      </v-col>
      <!-- col2 -->
      <v-col
        cols="123"
        md="4"
      >
        <v-row class="ma-n3">
          <!-- col 2-1 -->
          <v-col cols="6">
            <v-sheet
              class="d-flex"
              color="green lighten-3"
              height="150"
            >
              <sheet-footer>
                #2: (1r x 1c)
              </sheet-footer>
            </v-sheet>
          </v-col>
          <!-- col2-2 -->
          <v-col cols="6">
            <v-sheet
              class="d-flex"
              color="yellow lighten-3"
              height="150"
            >
              <sheet-footer>
                #3: (1r x 1c)
              </sheet-footer>
            </v-sheet>
          </v-col>
          <!-- col2-3 -->
          <v-col cols="12">
            <v-sheet
              class="d-flex"
              color="red lighten-3"
              height="250"
            >
              <sheet-footer>
                #5: (2r x 2c)
              </sheet-footer>
            </v-sheet>
          </v-col>
        </v-row>
      </v-col>

      <v-col
        cols="6"
        md="2"
      >
        <v-sheet
          class="d-flex"
          color="teal lighten-3"
          height="300"
        >
          <sheet-footer>
            #4: (2r x 1c)
          </sheet-footer>
        </v-sheet>
      </v-col>

      <v-col
        class="d-flex"
        cols="6"
        md="2"
      >
        <v-sheet
          class="d-flex mt-auto"
          color="purple lighten-3"
          height="300"
        >
          <sheet-footer>
            #6: (2r x 1c)
          </sheet-footer>
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
    </div>
</template>

<script>
export default {
  data: () => ({
    model: null
  })
}
</script>
