package MyPackage;
import org.lwjgl.opengl.GL11;

class terrace {

static String TextureName = "terrace.mtl";

static int Vertices = 13;

static int VertTexts = 48;

static int Normals = 48;

static int Faces = 16;

static int SmoothGroups = 2;

static float[][] VertArray = new float[][]{
{ 0.35f, 0.2f, 0.05f},
{ 0.35f, 0.2f, 0.35f},
{ 0.05f, 0.2f, 0.35f},
{ 0.05f, 0.2f, 0.05f},
{ 0.2f, 0.3f, 0.2f},
{ 0.35f, 0f, 0.05f},
{ 0.35f, 0f, 0.35f},
{ 0.05f, 0f, 0.35f},
{ 0.05f, 0f, 0.05f},
{ 0.05f, 0.2f, 0.05f},
{ 0.05f, 0.2f, 0.35f},
{ 0.35f, 0.2f, 0.35f},
{ 0.35f, 0.2f, 0.05f}};

static float[][] TextArray = new float[][]{
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 0f, 1f},
{ 1f, 0f},
{ 1f, 1f},
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
{ 1f, 1f},
{ 0f, 0f},
{ 1f, 0f},
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
{ 0f, 0.83205f, 0.5547f},
{ 0f, 0.83205f, 0.5547f},
{ 0f, 0.83205f, 0.5547f},
{ 0f, 0.83205f, -0.5547f},
{ 0f, 0.83205f, -0.5547f},
{ 0f, 0.83205f, -0.5547f},
{ 0.5547f, 0.83205f, -1.65314e-007f},
{ 0.5547f, 0.83205f, -1.65314e-007f},
{ 0.5547f, 0.83205f, -1.65314e-007f},
{ -0.5547f, 0.83205f, 8.26568e-008f},
{ -0.5547f, 0.83205f, 8.26568e-008f},
{ -0.5547f, 0.83205f, 8.26568e-008f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 1f, 0f, -2.98023e-007f},
{ 1f, 0f, -2.98023e-007f},
{ 1f, 0f, -2.98023e-007f},
{ 1f, 0f, -2.98023e-007f},
{ 1f, 0f, -2.98023e-007f},
{ 1f, 0f, -2.98023e-007f},
{ -1f, 0f, 1.49012e-007f},
{ -1f, 0f, 1.49012e-007f},
{ -1f, 0f, 1.49012e-007f},
{ -1f, 0f, 1.49012e-007f},
{ -1f, 0f, 1.49012e-007f},
{ -1f, 0f, 1.49012e-007f},
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
{ 5, 1, 1, 3, 2, 2, 2, 3, 3, 1},
{ 5, 4, 4, 1, 5, 5, 4, 6, 6, 1},
{ 1, 7, 7, 5, 8, 8, 2, 9, 9, 1},
{ 3, 10, 10, 5, 11, 11, 4, 12, 12, 1},
{ 12, 13, 13, 8, 14, 14, 7, 15, 15, 2},
{ 8, 16, 16, 12, 17, 17, 11, 18, 18, 2},
{ 10, 19, 19, 6, 20, 20, 9, 21, 21, 2},
{ 6, 22, 22, 10, 23, 23, 13, 24, 24, 2},
{ 12, 25, 25, 6, 26, 26, 13, 27, 27, 2},
{ 6, 28, 28, 12, 29, 29, 7, 30, 30, 2},
{ 8, 31, 31, 10, 32, 32, 9, 33, 33, 2},
{ 10, 34, 34, 8, 35, 35, 11, 36, 36, 2},
{ 10, 37, 37, 12, 38, 38, 13, 39, 39, 2},
{ 12, 40, 40, 10, 41, 41, 11, 42, 42, 2},
{ 8, 43, 43, 6, 44, 44, 7, 45, 45, 2},
{ 6, 46, 46, 8, 47, 47, 9, 48, 48, 2}};

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

//Vertices: 13  Texture Co-ords: 48  Normals: 48  Texture: terrace.mtl Faces: 16 Smooth Groups: 2