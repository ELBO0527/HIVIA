import router from '@/router'

const userModule = {
    state : {
        id : "",
        passwd : "",
        token : ""
    },
    mutations : {
        login: function(state, payload){
            console.log(payload.id)
            console.log(payload.email)
            console.log(payload.token)
            state.id = payload.id
            state.email = payload.email
            state.token = payload.token
        },
        loginCheck: function(state){
            if(!state.token){
                router.push({
                    name: 'Signin'
                }).catch(error => {
                    console.log(error)
                })
            }
        }
    }
}

export default userModule