import { Link } from 'react-router-dom';
import {Nav, Navbar, NavbarBrand, NavItem} from 'reactstrap';

function Header() {
    return(
        <div style={{width:"100%"}}>
            <Navbar slight>
                {/* <Nav navbar className="ml-auto">
                    <NavbarBrand>
                        <Link to="/"><b>Kosta.com</b></Link>
                    </NavbarBrand>
                    <NavItem>
                            <Link to="/login">로그인</Link>
                    </NavItem>
                    <NavItem>
                            <Link to="/join">회원가입</Link>
                    </NavItem>
                    <NavItem>
                            <Link to="/boardlist">게시판</Link>
                    </NavItem>
                </Nav> */}
            </Navbar>
        </div>
    )
}

export default Header;