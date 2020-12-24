<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>
    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	 <link href="css/tables.css" rel="stylesheet">
	 
	 
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="main.bo">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Addons
            </div>



            <!-- Nav Item - Tables -->
            <li class="nav-item active">
                <a class="nav-link" href="main.bo">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Board</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Board</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">글 상세보기</h6>
                        </div>
                        <div class="card-body">
							<div class="row"> 
                   			</div>
                   		  <div class="table-group">
								<div class="board-form">
									<div class="mb-3">
										<label for="exampleFormControlInput1" class="form-label">제목</label> 
										<input type="text" class="form-control" name="subject" value="${bb.subject }" readonly="readonly">
										</div>
			
									<div class="mb-3">
										<label for="exampleFormControlInput1" class="form-label">작성자</label> 
										<input type="text" class="form-control name" name="name" value="${bb.name }" readonly="readonly">
									</div>
									<div class="mb-3">
										<label for="exampleFormControlTextarea1" class="form-label">내용</label>
										<textarea class="form-control" rows="7" name="content" readonly="readonly">${bb.content }</textarea>
									</div>
									<div class="mb-3">
										<c:if test="${bb.file != null}">
											<label for="formFile" class="form-label">파일</label>
											<input class="form-control" type="text" name="file" id="file" value="파일 다운로드 : ${bb.originFile}" onclick="location.href='download.bo?file=${bb.file}'" readonly="readonly">
										</c:if>
									</div>
								</div>
						</div>
                   		<div class="row">
                    		<div class="col-sm-12 col-md-5">
                    			<div class="btns-group">
                    				<button type="button" class="btn btn-primary" onclick="location.href='replyForm.bo?num=${bb.num}'">reply</button>  
                    				<button type="button" class="btn btn-primary" onclick="location.href='updateForm.bo?num=${bb.num}'">update</button>  
									<button type="button" class="btn btn-primary" id="modal_open_btn">delete</button>
										<div id="modal">
											<div class="modal_content">
												<h5>삭제 하시겠습니까?</h5>
												<button type="button"  class="btn btn-secondary btn-lg" onclick="location.href='delete.bo?num=${bb.num}'">예</button>
												<button type="button"  class="btn btn-secondary btn-lg" id="modal_close_btn">아니오</button>
											</div>
										</div>
                    				<button type="button" class="btn btn-primary" onclick="location.href='main.bo?searchFlag=${scri.searchFlag }&search=${scri.search}&pageNum=${scri.pageNum}'">list</button>
                    			</div>              			
                    		</div>
                    		<div class="col-sm-12 col-md-7">
                    		</div>
                    	</div>
                  	  </div>
                    </div>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script> 
    <script type="text/javascript">
		$(document).ready(function(){
			$("#modal_open_btn").click(function(){
				$("#modal").attr("style", "display:block");
			});
	
			$("#modal_close_btn").click(function(){
				$("#modal").attr("style", "display:none");
			});
		});
	</script>

</body>

</html>