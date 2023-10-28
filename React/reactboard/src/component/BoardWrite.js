import './BoardWrite.css';
import { Button, Card, CardBody, Col, Form, FormGroup, Input, InputGroup, Label } from "reactstrap";
import { Link } from "react-router-dom";

function BoardWrite() {
  return (
    <div>
      <h4 style={{ margin: '20px' }}>게시판글등록</h4>

      <Card style={{ width: '600px', margin: "0 auto" }}>
        <CardBody>
          <Form>
            <FormGroup row>
              <Col sm={3} style={{ textAlign: 'left' }}>
                <Label for="writer">글쓴이</Label>
              </Col>
              <Col sm={9}>
                <Input type="text" name="writer" id="writer" />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Col sm={3} style={{ textAlign: 'left' }}>
                <Label for="title">제 목</Label>
              </Col>
              <Col sm={9}>
                <Input type="text" name="title" id="title" />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Col sm={3} style={{ textAlign: 'left' }}>
                <Label for="title">내 용</Label>
              </Col>
              <Col sm={9}>
                <Input type="textarea" style={{ height: "400px" }} name="content" id="content" />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Col sm={3} style={{ textAlign: 'left' }}>
                <Label for="file">이미지 파일 첨부</Label>
              </Col>
              <Col sm={9}>
                <InputGroup>
                  <Input type="file" name="file" id="file" />
                </InputGroup>
              </Col>
            </FormGroup>
            <Button color="primary">
              <Link to="/board" style={{ textDecoration: "none", color: 'white' }}>
                등록
              </Link>
            </Button>&nbsp;&nbsp;
            <Button color="primary">
              <Link to="/board" style={{ textDecoration: "none", color: 'white' }}>
                다시쓰기
              </Link>
            </Button>
          </Form>
        </CardBody>
      </Card>
    </div>
  )
}

export default BoardWrite;