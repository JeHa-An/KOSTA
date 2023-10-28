import { Link } from 'react-router-dom';
import { Nav, NavItem, Navbar, NavbarBrand } from 'reactstrap';

function Header() {
  return (
    <div>
      <Navbar color='light' style={{ justifyContent: "flex-start" }} navbar>
        <NavbarBrand>
          <Link to="/" style={{ textDecoration: "none", color: 'black' }}><i><b>Kosta.com</b></i></Link>
        </NavbarBrand>
        <Nav navbar>
          <NavItem>
            <Link to="/board" style={{ textDecoration: "none", color: 'gray' }}>로그인</Link>&nbsp;&nbsp;
          </NavItem>
        </Nav>
        <Nav >
          <NavItem>
            <Link to="/board" style={{ textDecoration: "none", color: 'gray' }}>회원가입</Link>&nbsp;&nbsp;
          </NavItem>
        </Nav>
        <Nav navbar>
          <NavItem>
            <Link to="/board" style={{ textDecoration: "none", color: 'gray' }}>게시판</Link>&nbsp;&nbsp;
          </NavItem>
        </Nav>
      </Navbar>
    </div>
  )
}

export default Header;