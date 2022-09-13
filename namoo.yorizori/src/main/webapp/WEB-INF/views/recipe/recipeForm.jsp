<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <!DOCTYPE html>
  <html lang="ko">

  <head>
    <meta charset="utf-8" />
    <meta name="요리책 상세보기port" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${ctx}/css/styles.css" rel="stylesheet" />
    <script type="module" defer src="${ctx}/js/modify.js"></script>
  </head>

  <body>
    <!-- Navigation-->
    <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
    <!-- Header-->

    <!-- Section-->
    <section class="py-5">
      <div class="container">
        <div class="row">
          <div class="col-lg-9">
            <div class="col-auto h2">레시피 등록</div>
            <!-- recipe Form -->
            <form class="row g-3" action="${ctx}/recipe/regist.do" method="post" enctype="multipart/form-data">
              <div class="col-md-6">
                <label for="recipe_name" class="form-label">레시피명</label> <input type="text" class="form-control"
                  id="recipe_name" name="recipe_name">
              </div>
              <div class="col-md-6">
                <label for="writer_name" class="form-label">등록자</label> <input type="text" class="form-control"
                  id="writer_name" value="${loginUser.name}" disabled>
                <input type="hidden" name="writer_id" value="${loginUser.id}">
                <input type="hidden" name="book_id" value="${param.cbid}">

              </div>
              <div class="col-md-6">
                <label for="recipe_time" class="form-label">조리시간</label> <input type="number" class="form-control"
                  id="recipe_time" name="recipe_time">
              </div>
              <div class="col-md-4">
                <label for="recipe_level" class="form-label">난이도</label> <select id="recipe_level" class="form-select"
                  name="recipe_level">
                  <option value="3" selected>상</option>
                  <option value="2">중</option>
                  <option value="1">하</option>
                </select>
              </div>

              <div class="col-12">
                <label for="ingredients" class="form-label">재료</label>
                <textarea class="form-control" rows="5" id="ingredients" name="ingredients">된장, 물, 대파, 돼지고기</textarea>
              </div>

              <div class="col-12" id="sequence">
                <label for="seq_num1" class="form-label">조리절차</label> <input type="text" class="form-control"
                  id="seq_num" name="seq_num">
                <input type="text" class="form-control" id="seq_num" name="seq_num">
                <input type="text" class="form-control thrid" id="seq_num" name="seq_num">
              </div>
              
              <div class="col-12" id="recipe_sequence">
                <input type="button" class="btn btn-info btn-sm" value="추가" id="add">
                <input type="button" class="btn btn-info btn-sm" value="삭제" id="del">
              </div>

              <div class="col-12">
                <label for="img_file_name" class="form-label">조리사진</label>
                <input type="file" class="form-control" id="img_file_name" name="img_file_name">
              </div>

              <div class="col-12 modify">
                <button type="submit" class="btn btn-primary bt">등록</button>
                <a href="${local }" class="btn btn-success">목록</a>
              </div>
            </form>
          </div>
        </div>
      </div>
      
    </section>

    <!-- Footer-->
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
  </body>

  </html>