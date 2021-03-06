x=0:.1:10; %0 0.1 0.2…10  一维矩阵 等差
y=0.12*exp(-0.213*x)+0.54*exp(-0.17*x).*sin(1.23*x);%点乘
%匿名函数，结构与目标函数差不多，系数通过高精度拟合
f=@(a,x)a(1)*exp(-a(2)*x)+a(3)*exp(-a(4)*x).*sin(a(5)*x);
%建立函数原型，则可以根据它来进行下面的求取系数的计算
[xx,res]=lsqcurvefit(f,[1,1,1,1,1],x,y);
%lsqcurvefit( )是非线性最小二乘拟合函数，其本质上是求解最优化问题。
%其使用格式为:
%  x=lsqcurvefit(fun,x0,xdata,ydata)  其中，fun是要拟合的非线性函数，
%  x0是初始参数，xdata，ydata是拟合点的数据，该函数最终返回系数矩阵。
x1=0:0.01:10;
y1=f(xx,x1);  %系数 与自变量拟合
plot(x1,y1,x,y,'o');