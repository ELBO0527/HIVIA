<template>
  <div>
    <v-row>
      <v-col cols="12" md="12">
        <v-sheet color="grey lighten-3" height="380">
          <v-row>
            <v-col class="pa-3" cols="6" md="3">
              <v-sheet color="white">
                <h1>123</h1>
              </v-sheet>
            </v-col>
          </v-row>
        </v-sheet>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  data: () => ({
    return: {
      page: 1
    },
    v0: true,
    selectedItem: 0,
    items: [
      { text: "일반 사무용SW" },
      { text: "콘텐츠 관련 SW" },
      { text: "ERP/ERM" },
      { text: "CRM" },
      { text: "SCM/SRM" },
      { text: "Collaboration SW" },
      { text: "엔지니어링․과학용 SW" }
    ]
  }),

  methods: {
    clickMe() {
      this.loading = true;
      this.message = "Wait for it...";
      setTimeout(() => {
        this.loading = false;
        this.message = "You have clicked me!";
      }, 2000);
    }
  }
};
</script>
