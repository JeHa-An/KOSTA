export const initTodos = [
    {
        id : 1,
        title : 'Todo1',
        count : 0,
        complete : false
    },
    {
        id : 2,
        title : 'Todo2',
        count : 0,
        complete : false
    },
    {
        id : 3,
        title : 'Todo3',
        count : 0,
        complete : true
    }
]

export const reducer = (state, action) => {
    switch(action.type) {
        case "COMPLETE" : 
            return (
                state.map(item=> {
                    if(item.id === action.id) return {...item, complete:!item.complete}
                    else return item
                })
            )
        case "INCREMENT" : 
            return(
                state.map(item=> {
                    if(item.id === action.id) return {...item, count:item.count+1}
                    else return item
                })
            )
        
        default : return state;
    }
}