<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Theme Template for Bootstrap</title>

	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/holder.min.js"></script>
  </head>
<body>
	
	<!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    
    <div class="container containerdiv1">
      	<div class="row">
    		<div class="col-md-4">
    			 <div class="panel panel-default ">
    			 	<div class="panel-heading">
		              <h3 class="panel-title">Panel title</h3>
		            </div>
		            <div class="panel-body fixed-panel">
		              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam eget risus varius blandit sit amet non magna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Aenean lacinia bibendum nulla sed consectetur. Gaurav</p>
		              <p>
		              	<button class="btn btn-primary ">LIKE</button> 
		              	<button class="btn btn-info ">DISLIKE</button>
		              </p>
		            </div>
    			 </div>
    		</div>


    		<div class="col-md-4">
    			 <div class="panel panel-default ">
    			 	<div class="panel-heading">
		              <h3 class="panel-title">Panel title</h3>
		            </div>
		            <div class="panel-body fixed-panel">
		              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam eget risus varius blandit sit amet non magna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Aenean lacinia bibendum nulla sed consectetur.</p>
		            </div>
    			 </div>
    		</div>

    		<div class="col-md-4">
    			 <div class="panel panel-default ">
    			 	<div class="panel-heading">
		              <h3 class="panel-title">Panel title</h3>
		            </div>
		            <div class="panel-body fixed-panel" >
		              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam eget risus varius blandit sit amet non magna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Aenean lacinia bibendum nulla sed consectetur.</p>
		            </div>
    			 </div>
    		</div>
    	</div>	
    </div>
    
    
    <div class='container'>
    	<div class="page-header">
        <h1>Tables</h1>
      </div>
      <div class="row">
          <table class="table table-condensed table-bordered table-striped">
            <thead>
              <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Username</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <td>2</td>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
                <td>@mdo</td>
              </tr>
            </tbody>
          </table>
        </div>
    </div>
    
    
    
    
    
    <div class="container">
    	<div class="page-header">
        	<h1>Thumbnails Panel</h1>
      	</div>
      	<div class="row">
			 <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/100%x200/size:25" src="${pageContext.request.contextPath}/assets/images/alia.jpg">
			      <div class="caption">
			        <p>
			        	<a href="#" class="btn btn-primary" role="button">Button</a> 
			        	<a href="#" class="btn btn-default" role="button">Button</a>
			        </p>
			      </div>
			    </div>
			  </div>	  
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/100%x200/size:25">
			      <div class="caption">
			        <p>
			        	<a href="#" class="btn btn-primary" role="button">Button</a> 
			        	<a href="#" class="btn btn-default" role="button">Button</a>
			        </p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/100%x200/size:25">
			      <div class="caption">
			        <p>
			        	<a href="#" class="btn btn-primary" role="button">Button</a> 
			        	<a href="#" class="btn btn-default" role="button">Button</a>
			        </p>
			      </div>
			    </div>
			  </div>
		</div>	
    </div>
    
    
    <div class="container">
    	<div class="page-header">
        	<h1>FORMS</h1>
      	</div>
      	<div class="row">
      		<div class="col-md-6">
      			<form class="form-horizontal">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-6">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Remember me
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Sign in</button>
			    </div>
			  </div>
			</form>
      		</div>
      		
      		<div class="col-md-6">
      			<form class="form-horizontal">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-10">
			      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Remember me
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Sign in</button>
			    </div>
			  </div>
			</form>
      		</div>
      	</div>
      	</div>
      	
      	
      	
        
</body>
</html>
