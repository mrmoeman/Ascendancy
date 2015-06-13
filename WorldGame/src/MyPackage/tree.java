package MyPackage;
import org.lwjgl.opengl.GL11;


class tree {

static String TextureName = "tree.mtl";

static int Vertices = 16;

static int VertTexts = 72;

static int Normals = 72;

static int Faces = 24;

static int SmoothGroups = 2;

static float[][] VertArray = new float[][]{
{ 0.3f, 1f, 0.3f},
{ 0.7f, 1f, 0.3f},
{ 0.7f, 1f, 0.7f},
{ 0.3f, 1f, 0.7f},
{ 0.3f, 0.5f, 0.7f},
{ 0.7f, 0.5f, 0.7f},
{ 0.7f, 0.5f, 0.3f},
{ 0.3f, 0.5f, 0.3f},
{ 0.4f, 0f, 0.4f},
{ 0.6f, 0f, 0.4f},
{ 0.6f, 0f, 0.6f},
{ 0.4f, 0f, 0.6f},
{ 0.4f, 0.5f, 0.6f},
{ 0.6f, 0.5f, 0.6f},
{ 0.6f, 0.5f, 0.4f},
{ 0.4f, 0.5f, 0.4f}};

static float[][] TextArray = new float[][]{
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
{ 1f, 0f},
{ 0f, 1f},
{ 0f, 0f},
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
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, -1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
{ 0f, 1f, 0f},
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
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ 1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ -1f, 0f, 0f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, -1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
{ 0f, 0f, 1f},
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
{ 6, 1, 1, 8, 2, 2, 7, 3, 3, 1},
{ 8, 4, 4, 6, 5, 5, 5, 6, 6, 1},
{ 4, 7, 7, 2, 8, 8, 1, 9, 9, 1},
{ 2, 10, 10, 4, 11, 11, 3, 12, 12, 1},
{ 6, 13, 13, 4, 14, 14, 5, 15, 15, 1},
{ 4, 16, 16, 6, 17, 17, 3, 18, 18, 1},
{ 2, 19, 19, 8, 20, 20, 1, 21, 21, 1},
{ 8, 22, 22, 2, 23, 23, 7, 24, 24, 1},
{ 4, 25, 25, 8, 26, 26, 5, 27, 27, 1},
{ 8, 28, 28, 4, 29, 29, 1, 30, 30, 1},
{ 2, 31, 31, 6, 32, 32, 7, 33, 33, 1},
{ 6, 34, 34, 2, 35, 35, 3, 36, 36, 1},
{ 15, 37, 37, 11, 38, 38, 10, 39, 39, 2},
{ 11, 40, 40, 15, 41, 41, 14, 42, 42, 2},
{ 13, 43, 43, 9, 44, 44, 12, 45, 45, 2},
{ 9, 46, 46, 13, 47, 47, 16, 48, 48, 2},
{ 15, 49, 49, 9, 50, 50, 16, 51, 51, 2},
{ 9, 52, 52, 15, 53, 53, 10, 54, 54, 2},
{ 11, 55, 55, 13, 56, 56, 12, 57, 57, 2},
{ 13, 58, 58, 11, 59, 59, 14, 60, 60, 2},
{ 13, 61, 61, 15, 62, 62, 16, 63, 63, 2},
{ 15, 64, 64, 13, 65, 65, 14, 66, 66, 2},
{ 11, 67, 67, 9, 68, 68, 10, 69, 69, 2},
{ 9, 70, 70, 11, 71, 71, 12, 72, 72, 2}};

static int Temp = 0;

public static void Draw(int Humidity, float Height){
	
	for(int i = 0; i < Faces; i++ ){
		
		if (GetFaceData(i, 9) == 2){
			GL11.glColor3f(0.03f, 0.34f, 0.01f);
		}
		if (GetFaceData(i, 9) == 1){
			if (Humidity > -1){
				GL11.glColor3f(0.07f, 0.53f, 0.03f);
			}
			if (Humidity == -1){
				GL11.glColor3f(0.05f, 0.45f, 0.02f);
			}
			if (Humidity == -2){
				GL11.glColor3f(0.04f, 0.34f, 0.01f);
			}
			if (Humidity == -3){
				GL11.glColor3f(0.03f, 0.24f, 0.01f);
			}
		}
		
		if ((GetFaceData(i, 9) == 1 && Humidity > -4) || GetFaceData(i, 9) == 2){
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

//Vertices: 16  Texture Co-ords: 72  Normals: 72  Texture: tree.mtl Faces: 24 Smooth Groups: 2