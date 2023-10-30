export const initState = {
    id : 'an',
    nickname : 'jeha',
    subject : 'computer',
    grade : 1
}

export const reducer = (state, action) => {
    switch(action.type) {
        case 'id' : return {...state, id : action.payload};
        case 'nickname' : return {...state, nickname : action.payload};
        case 'subject' : return {...state, subject : action.payload};
        case 'grade' : return {...state, grade : action.payload};
        default : return state;
    }
}