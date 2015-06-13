package MyPackage;
import org.lwjgl.opengl.GL11;

class house {

static String TextureName = "house.mtl";

static int Vertices = 14;

static int VertTexts = 54;

static int Normals = 54;

static int Faces = 18;

static int SmoothGroups = 2;

static float[][] VertArray = new float[][]{
{ 0.2f, 0.3f, 0.18f},
{ 0.2f, 0.3f, 0.42f},
{ 0.3f, 0.2f, 0.1f},
{ 0.3f, 0.2f, 0.5f},
{ 0.1f, 0.2f, 0.5f},
{ 0.0999999f, 0.2f, 0.1f},
{ 0.3f, 0f, 0.1f},
{ 0.3f, 0f, 0.5f},
{ 0.1f, 0f, 0.5f},
{ 0.1f, 0f, 0.1f},
{ 0.1f, 0.2f, 0.1f},
{ 0.1f, 0.2f, 0.5f},
{ 0.3f, 0.2f, 0.5f},
{ 0.3f, 0.2f, 0.1f}};

static float[][] TextArray = new float[][]{
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
{ 0f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 0f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 1f, 0f},
{ 0f, 1f},
{ 0f, 0f},
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 1f, 0f},
{ 0f, 1f},
{ 0f, 0f},
{ 0f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
{ 0f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 1f, 0f},
{ 0f, 1f},
{ 0f, 0f},
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
{ 0f, 0f},
{ 1f, 1f},
{ 0f, 1f}};

static float[][] NormArray = new float[][]{
{ -0.707107f, 0.707107f, 1.14148e-007f},
{ -0.707107f, 0.707107f, 1.14148e-007f},
{ -0.707107f, 0.707107f, 5.26836e-008f},
{ -0.707107f, 0.707107f, 1.14148e-007f},
{ -0.707107f, 0.707107f, 1.14148e-007f},
{ -0.707107f, 0.707107f, 1.75612e-007f},
{ 0.707107f, 0.707107f, -1.4049e-007f},
{ 0.707107f, 0.707107f, -1.4049e-007f},
{ 0.707107f, 0.707107f, -1.75612e-007f},
{ 0.707107f, 0.707107f, -1.4049e-007f},
{ 0.707107f, 0.707107f, -1.4049e-007f},
{ 0.707107f, 0.707107f, -1.05367e-007f},
{ -1.16358e-007f, 0.624695f, -0.780869f},
{ -1.16358e-007f, 0.624695f, -0.780869f},
{ -1.16358e-007f, 0.624695f, -0.780869f},
{ 0f, 0.624695f, 0.780869f},
{ 0f, 0.624695f, 0.780869f},
{ 0f, 0.624695f, 0.780869f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ -7.45058e-008f, 0f, -1f},
{ -7.45058e-008f, 0f, -1f},
{ -7.45058e-008f, 0f, -1f},
{ -7.45058e-008f, 0f, -1f},
{ -7.45058e-008f, 0f, -1f},
{ -7.45058e-008f, 0f, -1f},
{ 1f, 0f, -1.49012e-007f},
{ 1f, 0f, -1.49012e-007f},
{ 1f, 0f, -1.49012e-007f},
{ 1f, 0f, -1.49012e-007f},
{ 1f, 0f, -1.49012e-007f},
{ 1f, 0f, -1.49012e-007f},
{ -1f, 0f, 7.45058e-008f},
{ -1f, 0f, 7.45058e-008f},
{ -1f, 0f, 7.45058e-008f},
{ -1f, 0f, 7.45058e-008f},
{ -1f, 0f, 7.45058e-008f},
{ -1f, 0f, 7.45058e-008f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f}};

static int[][] FaceArray = new int[][]{
{ 5, 1, 1, 1, 2, 2, 6, 3, 3, 1},
{ 1, 4, 4, 5, 5, 5, 2, 6, 6, 1},
{ 2, 7, 7, 3, 8, 8, 1, 9, 9, 1},
{ 3, 10, 10, 2, 11, 11, 4, 12, 12, 1},
{ 1, 13, 13, 3, 14, 14, 6, 15, 15, 1},
{ 2, 16, 16, 5, 17, 17, 4, 18, 18, 1},
{ 13, 19, 19, 9, 20, 20, 8, 21, 21, 2},
{ 9, 22, 22, 13, 23, 23, 12, 24, 24, 2},
{ 11, 25, 25, 7, 26, 26, 10, 27, 27, 2},
{ 7, 28, 28, 11, 29, 29, 14, 30, 30, 2},
{ 13, 31, 31, 7, 32, 32, 14, 33, 33, 2},
{ 7, 34, 34, 13, 35, 35, 8, 36, 36, 2},
{ 9, 37, 37, 11, 38, 38, 10, 39, 39, 2},
{ 11, 40, 40, 9, 41, 41, 12, 42, 42, 2},
{ 11, 43, 43, 13, 44, 44, 14, 45, 45, 2},
{ 13, 46, 46, 11, 47, 47, 12, 48, 48, 2},
{ 9, 49, 49, 7, 50, 50, 8, 51, 51, 2},
{ 7, 52, 52, 9, 53, 53, 10, 54, 54, 2}};

static int Temp = 0;

public static void Draw(float Height){
	
	
	for(int i = 0; i < Faces; i++ ){
		
		if (GetFaceData(i, 9) == 2){
			GL11.glColor3f(0.87f, 0.72f, 0.54f);		//HOUSE YOLO
		}
		if (GetFaceData(i, 9) == 1){
			GL11.glColor3f(0.82f, 0.49f, 0.34f);		//ROOF YOLO
		}
		
        GL11.glBegin(GL11.GL_TRIANGLES);                    // Drawing Using Triangles
        
        Temp = GetFaceData(i, 2)-1;
        	GL11.glNormal3f( GetNormalData(Temp, 0), GetNormalData(Temp, 1), GetNormalData(Temp, 2));         
        Temp = GetFaceData(i, 0)-1;
            GL11.glVertex3f( GetVerticeData(Temp, 0), GetVerticeData(Temp, 1) + Height, GetVerticeData(Temp, 2));         
            
        Temp = GetFaceData(i, 5)-1;
        	GL11.glNormal3f( GetNormalData(Temp, 0), GetNormalData(Temp, 1), GetNormalData(Temp, 2));   
        Temp = GetFaceData(i, 3)-1;
        GL11.glVertex3f( GetVerticeData(Temp, 0), GetVerticeData(Temp, 1) + Height, GetVerticeData(Temp, 2));        
        
        Temp = GetFaceData(i, 8)-1;
    		GL11.glNormal3f( GetNormalData(Temp, 0), GetNormalData(Temp, 1), GetNormalData(Temp, 2));   
        Temp = GetFaceData(i, 6)-1;
            GL11.glVertex3f( GetVerticeData(Temp, 0), GetVerticeData(Temp, 1) + Height, GetVerticeData(Temp, 2));         
        GL11.glEnd();   
        
        }

}

public static int GetVertices() {
return Vertices;
}

public static int GetVertTexts() {
return VertTexts;
}

public static int GetNormals() {
return Normals;
}

public static int GetFaces() {
return Faces;
}

public static int GetSmoothGroups() {
return SmoothGroups;
}

public static Float GetVerticeData(int i, int d) {
return VertArray[i][d];
}

public static Float GetVerticeTextureData(int i, int d) {
return TextArray[i][d];
}

public static Float GetNormalData(int i, int d) {
return NormArray[i][d];
}

public static int GetFaceData(int i, int d) {
return FaceArray[i][d];
}


}

//Vertices: 14  Texture Co-ords: 54  Normals: 54  Texture: house.mtl Faces: 18 Smooth Groups: 2