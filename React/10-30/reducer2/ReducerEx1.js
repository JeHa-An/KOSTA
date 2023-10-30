import { initTodos, reducer } from './MyReducer';
import { useReducer } from 'react';

const ReducerEx1 = () => {
    const [todos, dispatch] = useReducer(reducer, initTodos);
    
    return(
        <>
            {todos.map((item) => 
                <div key={item.id}>
                    <label>
                        <input type="checkbox" 
                            checked={item.complete} 
                            onChange={()=> dispatch({type:'COMPLETE', id:item.id})}
                        />
                        {item.title}&nbsp;&nbsp;&nbsp;
                        {item.count}&nbsp;&nbsp;&nbsp;
                        <button onClick={()=> dispatch({type:'INCREMENT', id:item.id})}>
                            +
                        </button>
                    </label>
                </div>
            )}
        </>
    )
}

export default ReducerEx1;