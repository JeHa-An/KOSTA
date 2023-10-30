export const initState = {
    count : 0
}

export const countingReducer = (state=initState, action) => {
    switch(action.type) {
        case 'PUSH' : return {...state, count:state.count+1}
        default : return state
    }
}