import './Board.css';
import { useState } from "react";
import { Button, ButtonDropdown, Col, Dropdown, DropdownItem, DropdownMenu, DropdownToggle, Form, FormGroup, Input, Pagination, PaginationItem, PaginationLink, Row, Table } from "reactstrap";
import { Link } from "react-router-dom";

function Board() {
  const [open, setOpen] = useState(false);
  const [search, setSearch] = useState('제목')

  const toggle = () => { setOpen(!open) };
  const searchs = (temp) => { setSearch(temp) };

  return (
    <div style={{ margin: '0 auto', width: '900px' }}>
      <div style={{ marginTop: '20px' }}>
        <h3>게시판글 목록</h3>
      </div>

      <Form style={{ width: '70%', margin: '0 auto', marginTop: '50px' }} >
        <Row>
          <Col>
            <Dropdown isOpen={open} toggle={toggle}>
              <DropdownToggle caret outline>{search}</DropdownToggle>
              <DropdownMenu>
                <DropdownItem onClick={() => searchs('제목')}>제목</DropdownItem>
                <DropdownItem onClick={() => searchs('내용')}>내용</DropdownItem>
                <DropdownItem onClick={() => searchs('번호')}>번호</DropdownItem>
              </DropdownMenu>
            </Dropdown>
          </Col>
          <Col>
            <Input />
          </Col>
          <Col>
            <Button>검색</Button>
          </Col>
          <Col>
            <Button color="success">
              <Link to="/boardwrite" style={{ textDecoration: "none", color: 'white' }}>글쓰기</Link>
            </Button>
          </Col>
        </Row>
      </Form>

      <Table bordered style={{ marginTop: '10px', width: '100%', textAlign: 'left' }}>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><Link to="/boarddetail">1</Link></td>
            <td>제목1</td>
            <td>안제하</td>
            <td>2023-10-28</td>
            <td>5</td>
            <td><Button>삭제</Button></td>
          </tr>
        </tbody>
      </Table>

      <Pagination>
        <PaginationItem>
          <PaginationLink previous href="#" />
        </PaginationItem>
        <PaginationItem active>
          <PaginationLink href="#">1</PaginationLink>
        </PaginationItem>
        <PaginationItem>
          <PaginationLink href="#">2</PaginationLink>
        </PaginationItem>
        <PaginationItem>
          <PaginationLink href="#">3</PaginationLink>
        </PaginationItem>
        <PaginationItem>
          <PaginationLink href="#">4</PaginationLink>
        </PaginationItem>
        <PaginationItem>
          <PaginationLink href="#">5</PaginationLink>
        </PaginationItem>
        <PaginationItem>
          <PaginationLink next href="#" />
        </PaginationItem>
      </Pagination>
    </div>
  )
}

export default Board;