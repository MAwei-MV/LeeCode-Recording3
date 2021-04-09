package Main;

public class Pro48 {
    //先沿右上 - 左下的对角线翻转（270° +270°+ 一次镜像），
    // 再沿水平中线上下翻转（-180° +−180°+ 一次镜像），可以实现顺时针 9090 度的旋转效果
    public void rotate(int[][] matrix){
        if(matrix.length==0||matrix==null) return;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-j-1][matrix.length-i-1];
                matrix[matrix.length-j-1][matrix.length-i-1]=temp;
            }

        }
        for(int i=0;i<matrix.length>>1;i++){
            for(int j=0;j<matrix.length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j]=temp;
            }
        }
    }
}
