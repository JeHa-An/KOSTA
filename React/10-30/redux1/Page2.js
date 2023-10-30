import {useSelector, useDispatch} from 'react-redux';

const Page2 = () => {
    const data2 = useSelector(state => state.data2);
    const dispatch = useDispatch();

    return (
        <div>
            <h1>{data2}</h1>
            <button onClick={()=> dispatch({type:"INT", data:100})}>문자열 변경</button>
        </div>
    );
};

export default Page2;