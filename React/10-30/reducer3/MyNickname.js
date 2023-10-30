
const MyNickname = ({info, dispatch}) => {
    return (
        <>
            <label>{info.nickname}</label>&nbsp;&nbsp;&nbsp;
            <input type="text" onInput={(e)=> dispatch({type:'nickname', payload: e.target.value})}/>
            <br/>
        </>
    )
}

export default MyNickname;