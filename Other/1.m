x=0:.1:10; %0 0.1 0.2��10  һά���� �Ȳ�
y=0.12*exp(-0.213*x)+0.54*exp(-0.17*x).*sin(1.23*x);%���
%�����������ṹ��Ŀ�꺯����࣬ϵ��ͨ���߾������
f=@(a,x)a(1)*exp(-a(2)*x)+a(3)*exp(-a(4)*x).*sin(a(5)*x);
%��������ԭ�ͣ�����Ը������������������ȡϵ���ļ���
[xx,res]=lsqcurvefit(f,[1,1,1,1,1],x,y);
%lsqcurvefit( )�Ƿ�������С������Ϻ������䱾������������Ż����⡣
%��ʹ�ø�ʽΪ:
%  x=lsqcurvefit(fun,x0,xdata,ydata)  ���У�fun��Ҫ��ϵķ����Ժ�����
%  x0�ǳ�ʼ������xdata��ydata����ϵ�����ݣ��ú������շ���ϵ������
x1=0:0.01:10;
y1=f(xx,x1);  %ϵ�� ���Ա������
plot(x1,y1,x,y,'o');