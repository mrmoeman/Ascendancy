package MyPackage;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

class Particle {
	

	static Texture PartText;
	static float Rotation = 0.0f;
	
	
	
	public static void LoadTextures() throws IOException{
	
	PartText = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/particle.png"));
	
	}
	
	public static void Update(){
		
		
		Rotation += 0.01f;
		
	}
	
	
	public static void DrawCircle(float Y){
		
		for (int i = 0; i <= 10; i++){
			for (int h = 0; h < 5; h++){
			
			// GL11.glTranslatef(0.5f, 0.0f, 0.5f);
			 GL11.glColor4f(1.0f, 0.0f, 1.0f, 0.8f);
				GL11.glBegin(GL11.GL_QUADS);                        // Draw top
					GL11.glTexCoord2f(0,0);
			 		GL11.glNormal3f( 0.0f, 1.0f, 0.0f);         
			 		GL11.glVertex3f(0.47f + (float)(Math.sin(Rotation + h*7.2 + i *36)/2), Y+0.1f + h * 0.1f, 0.47f+ (float)(Math.cos(Rotation + h*7.2 + i *36)/2));         // Top Left
			 		
			 		GL11.glTexCoord2f(1,0);
			 		GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
		        	GL11.glVertex3f( 0.53f+ (float)(Math.sin(Rotation + h*7.2 + i *36)/2), Y+0.1f+ h * 0.1f, 0.47f+ (float)(Math.cos(Rotation + h*7.2 + i *36)/2));         // Top Right
		        	
		        	GL11.glTexCoord2f(1,1);
		        	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
		        	GL11.glVertex3f( 0.53f+ (float)(Math.sin(Rotation + h*7.2 + i *36)/2),Y+0.1f+ h * 0.1f, 0.53f+ (float)(Math.cos(Rotation + h*7.2 + i *36)/2));         // Bottom Right
		        	
		        	GL11.glTexCoord2f(0,1);
		        	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
		        	GL11.glVertex3f(0.47f+ (float)(Math.sin(Rotation + h*7.2 + i *36)/2),Y+0.1f+ h * 0.1f, 0.53f+ (float)(Math.cos(Rotation + h*7.2 + i *36)/2));         // Bottom Left
		        GL11.glEnd();    
			
			}
		}
		
		
		
	}
	
	
	private static void Start(){
		GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping 
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, PartText.getTextureID());
		GL11.glDisable ( GL11.GL_LIGHTING );
		//GL11.glDisable(GL11.GL_COLOR_MATERIAL);
	}
	
	private static void End(){
		//GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glDisable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping 
		//GL11.glEnable ( GL11.GL_LIGHTING );
	}
	
	
	public static void Draw(float Y){
		
		Start();
		 
		 
		GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
		GL11.glBegin(GL11.GL_QUADS);                        // Draw top
			GL11.glTexCoord2f(0,0);
	 		GL11.glNormal3f( 0.0f, 1.0f, 0.0f);         
	 		GL11.glVertex3f(0.25f, Y+1.5f, 0.25f);         // Top Left
	 		
	 		GL11.glTexCoord2f(1,0);
	 		GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
        	GL11.glVertex3f( 0.75f, Y+1.5f, 0.25f);         // Top Right
        	
        	GL11.glTexCoord2f(1,1);
        	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
        	GL11.glVertex3f( 0.75f,Y+1.5f, 0.75f);         // Bottom Right
        	
        	GL11.glTexCoord2f(0,1);
        	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
        	GL11.glVertex3f(0.25f,Y+1.5f, 0.75f);         // Bottom Left
        GL11.glEnd();      
		
        End();
	}
	

}
