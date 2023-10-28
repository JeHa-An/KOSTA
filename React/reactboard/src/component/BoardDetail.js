import { Link } from "react-router-dom";
import { Button, Card, CardBody, Col, Form, FormGroup, Input, InputGroup, Label, Row } from "reactstrap";

function BoardDetail() {
  return (
    <div style={{ marginBottom: '20px' }}>
      <h4 style={{ margin: '20px' }}>게시판글상세</h4>

      <Card style={{ width: '600px', margin: "0 auto" }}>
        <CardBody>
          <Form>
            <FormGroup row>
              <Col sm={2} style={{ textAlign: 'left' }}>
                <Label for="writer">글쓴이</Label>
              </Col>
              <Col sm={10}>
                <Input type="text" name="writer" id="writer" style={{ background: 'white' }} disabled />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Col sm={2} style={{ textAlign: 'left' }}>
                <Label for="title">제 목</Label>
              </Col>
              <Col sm={10}>
                <Input type="text" name="title" id="title" style={{ background: 'white' }} disabled />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Col sm={2} style={{ textAlign: 'left' }}>
                <Label for="title">내 용</Label>
              </Col>
              <Col sm={10}>
                <Input type="textarea" style={{ height: "400px", background: 'white' }} name="content" id="content" disabled />
              </Col>
            </FormGroup>
            <FormGroup row style={{ textAlign: 'left' }}>
              <Col sm={2} >
                <Label for="file">이미지</Label>
              </Col>
              <Col sm={10}>
                <img src="logo192.png" />
              </Col>
            </FormGroup>
            <Button color="primary">
              <Link to="/board" style={{ textDecoration: "none", color: 'white' }}>
                수정
              </Link>
            </Button>&nbsp;&nbsp;
            <Button color="primary">
              <Link to="/board" style={{ textDecoration: "none", color: 'white' }}>
                게시판목록
              </Link>
            </Button>
          </Form>
        </CardBody>
      </Card>
    </div>
  )
}

export default BoardDetail;