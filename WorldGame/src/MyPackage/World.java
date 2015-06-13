package MyPackage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Random;

import org.lwjgl.opengl.GL11;



class World {
	
	static float Rotation = 0.0f;
	static float Orientation = 30.0f;
	static float WorldHeight[] = new float [100];
	static int WorldData[] = new int [100];
	static float WorldTimer[] = new float [100];
	static int WorldEffect[] = new int [100];
	static float WorldEffectTimer[] = new float [100];
	static int WorldRotate[] = new int [100];
	static int WorldParticleTimer[][] = new int [100][2];
	static Random randomGenerator = new Random();
	static float Height;
	static float GenSwitch = 0;
	static float DSwitch = 0;
	static float RSwitch = 0;
	static float Direction;
	static float TimeOfDay = 0.5f;
	static int TimeSwitch = 0;
	static float SeaLevel = -0.5f;
	static float SeaBase = -0.3f;
	static float SeaHeight;
	static int Humidity = 0;
	static int OldPopulation = 0;
	static int Population = 0;
	static int Trees = 0;
	static int Pollution;
	static int Polluted;
	static float PollutionTimer;
	static int Quake = 0;
	static float QuakeTimer = 0;
	static int Temp;
	static int SelectBox = 50;
	static float SelectRot = 0.0f;
	static boolean SelectActive = false;
	static boolean SelectSwitch = false;
	static boolean QSwitch = false;
	static boolean WSwitch = false;
	static boolean ESwitch = false;
	static boolean SSwitch = false;
	static boolean ASwitch = false;
	static boolean SpellSelect = false;
	static int WhichSpell = 0;
	static int Faith = 50;
	static int Food = 30;
	static float FoodTimer = 0;
	static float StarvationTimer = 0;
	static boolean Starve = false;
	static int TempMultiplier = 1;
	static int Age = 0;
	static float PollutionMultiplier = 1;
	static float FoodMultiplier = 1;
	static float PopulationMultiplier = 1;
	
	static int wintimer;
	
	static boolean won = true;
	
	static ShaderProgram Lighting;
	static boolean ShaderLoaded = false;
	
	public static void DrawWorld (){
		if(ShaderLoaded == false){
			 Lighting = new ShaderProgram("shader.vert", "shader.frag");
			 ShaderLoaded = true;
		}
		
		Lighting.Activate();
		
		GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f,0.0f,-20.0f);
        GL11.glRotatef(Orientation, 1, 0, 0);
        GL11.glRotatef(Rotation, 0, 1, 0);
        
        
        
        if (Quake == 1){
			GL11.glTranslatef((float)Math.sin(QuakeTimer)/8 ,0.0f, (float)Math.sin(QuakeTimer/2)/8); 
		}
		
		for (int i = 0; i < 10; i++){

			
			for (int p = 0; p < 10; p++){
				
				Height = WorldHeight[i*10 + p];

				GL11.glTranslatef(1.0f * i, 0.0f ,0.0f);  
				GL11.glTranslatef(0.0f ,0.0f, 1.0f * p); 
				
				GL11.glTranslatef(-5.0f ,0.0f, -5.0f); 
				
				GL11.glRotatef(90*WorldRotate[i*10 + p], 0, 1, 0);
				if (WorldRotate[i*10 + p] == 1){
					GL11.glTranslatef(-1.0f ,0.0f, 0.0f); 
				}
				if (WorldRotate[i*10 + p] == 2){
					GL11.glTranslatef(-1.0f ,0.0f, -1.0f); 
				}
				if (WorldRotate[i*10 + p] == 3){
					GL11.glTranslatef( 0.0f ,0.0f, -1.0f); 
				}
				
				if ( i*10 + p == SelectBox && SelectActive == true){
				GL11.glColor3f(0.0f, 0.0f, 0.0f);
				Lighting.DeActivate();
				if (WorldHeight[SelectBox] > SeaLevel + 0.01f){
					
				 GL11.glBegin(GL11.GL_QUADS);                        // Draw top
				 	GL11.glVertex3f( 1.05f, Height+0.01f, -0.05f);         // Top Left
	            	GL11.glVertex3f( -0.05f, Height+0.01f, -0.05f);         // Top Right
	            	GL11.glVertex3f( -0.05f,Height+0.01f, 0.05f);         // Bottom Left
	            	GL11.glVertex3f( 1.05f,Height+0.01f, 0.05f);         // Bottom Right
		        GL11.glEnd();      
		        
		        GL11.glBegin(GL11.GL_QUADS);                        // Draw top
	            	GL11.glVertex3f( 1.05f, Height+0.01f, 0.95f);         // Top Left
	            	GL11.glVertex3f( -0.05f, Height+0.01f, 0.95f);         // Top Right
	            	GL11.glVertex3f( -0.05f,Height+0.01f, 1.05f);         // Bottom Left
	            	GL11.glVertex3f( 1.05f,Height+0.01f, 1.05f);         // Bottom Right
	            GL11.glEnd();      
				
	            GL11.glBegin(GL11.GL_QUADS);                        // Draw top
            		GL11.glVertex3f( 1.05f, Height+0.01f, -0.05f);         // Top Left
            		GL11.glVertex3f( 0.95f, Height+0.01f, -0.05f);         // Top Right
            		GL11.glVertex3f( 0.95f,Height+0.01f, 1.05f);         // Bottom Left
            		GL11.glVertex3f( 1.05f,Height+0.01f, 1.05f);         // Bottom Right
            	GL11.glEnd();  
	            

            	GL11.glBegin(GL11.GL_QUADS);                        // Draw top
         			GL11.glVertex3f( 0.05f, Height+0.01f, -0.05f);         // Top Left
         			GL11.glVertex3f( -0.05f, Height+0.01f, -0.05f);         // Top Right
         			GL11.glVertex3f( -0.05f,Height+0.01f, 1.05f);         // Bottom Left
         			GL11.glVertex3f( 0.05f,Height+0.01f, 1.05f);         // Bottom Right
         		GL11.glEnd();
         		
         		//GL11.glRotatef(SelectRot, 0, 1, 0);
         		
         		GL11.glBegin(GL11.GL_TRIANGLE_FAN);                        // Draw top
         			GL11.glColor3f(0.99f, 0.61f, 0.01f);
     				GL11.glVertex3f( 0.5f, Height+1.5f, 0.5f);         // Top Left
     				GL11.glColor3f(0.99f, 0.91f, 0.06f);
     				
     				GL11.glVertex3f( 0.3f, Height+2.5f, 0.3f);         // Top Right
     				GL11.glVertex3f( 0.3f,Height+2.5f, 0.7f);         // Bottom Left
     				GL11.glVertex3f( 0.7f,Height+2.5f, 0.7f);         // Bottom Right
     				GL11.glVertex3f( 0.7f,Height+2.5f, 0.3f);         // Bottom Right
     				GL11.glVertex3f( 0.3f, Height+2.5f, 0.3f);         // Top Right
     			GL11.glEnd();
     			
     			GL11.glBegin(GL11.GL_TRIANGLE_FAN);                        // Draw top
     				GL11.glColor3f(0.99f, 0.61f, 0.01f);
     				GL11.glVertex3f( 0.5f, Height+3.5f, 0.5f);         // Top Left
     				GL11.glColor3f(0.99f, 0.91f, 0.06f);
 				
     				GL11.glVertex3f( 0.3f, Height+2.5f, 0.3f);         // Top Right
     				GL11.glVertex3f( 0.3f,Height+2.5f, 0.7f);         // Bottom Left
     				GL11.glVertex3f( 0.7f,Height+2.5f, 0.7f);         // Bottom Right
     				GL11.glVertex3f( 0.7f,Height+2.5f, 0.3f);         // Bottom Right
     				GL11.glVertex3f( 0.3f, Height+2.5f, 0.3f);         // Top Right
 				GL11.glEnd();
				}
				else{
					
					
					GL11.glBegin(GL11.GL_QUADS);                        // Draw top
					 GL11.glVertex3f( 1.05f, SeaLevel+0.2f, -0.05f);         // Top Left
		            	GL11.glVertex3f( -0.05f, SeaLevel+0.2f, -0.05f);         // Top Right
		            	GL11.glVertex3f( -0.05f,SeaLevel+0.2f, 0.05f);         // Bottom Left
		            	GL11.glVertex3f( 1.05f,SeaLevel+0.2f, 0.05f);         // Bottom Right
			        GL11.glEnd();      
			        
			        GL11.glBegin(GL11.GL_QUADS);                        // Draw top
		            	GL11.glVertex3f( 1.05f, SeaLevel+0.2f, 0.95f);         // Top Left
		            	GL11.glVertex3f( -0.05f, SeaLevel+0.2f, 0.95f);         // Top Right
		            	GL11.glVertex3f( -0.05f,SeaLevel+0.2f, 1.05f);         // Bottom Left
		            	GL11.glVertex3f( 1.05f,SeaLevel+0.2f, 1.05f);         // Bottom Right
		            GL11.glEnd();      
					
		            GL11.glBegin(GL11.GL_QUADS);                        // Draw top
	            		GL11.glVertex3f( 1.05f, SeaLevel+0.2f, -0.05f);         // Top Left
	            		GL11.glVertex3f( 0.95f, SeaLevel+0.2f, -0.05f);         // Top Right
	            		GL11.glVertex3f( 0.95f,SeaLevel+0.2f, 1.05f);         // Bottom Left
	            		GL11.glVertex3f( 1.05f,SeaLevel+0.2f, 1.05f);         // Bottom Right
	            	GL11.glEnd();  
		            

	            	GL11.glBegin(GL11.GL_QUADS);                        // Draw top
	         			GL11.glVertex3f( 0.05f, SeaLevel+0.2f, -0.05f);         // Top Left
	         			GL11.glVertex3f( -0.05f, SeaLevel+0.2f, -0.05f);         // Top Right
	         			GL11.glVertex3f( -0.05f,SeaLevel+0.2f, 1.05f);         // Bottom Left
	         			GL11.glVertex3f( 0.05f,SeaLevel+0.2f, 1.05f);         // Bottom Right
	         		GL11.glEnd();
	         		
	         		//GL11.glRotatef(SelectRot, 0, 1, 0);
	         		
	         		GL11.glBegin(GL11.GL_TRIANGLE_FAN);                        // Draw top
	         			GL11.glColor3f(0.99f, 0.61f, 0.01f);
	     				GL11.glVertex3f( 0.5f, SeaLevel+1.6f, 0.5f);         // Top Left
	     				GL11.glColor3f(0.99f, 0.91f, 0.06f);
	     				
	     				GL11.glVertex3f( 0.3f, SeaLevel+2.6f, 0.3f);         // Top Right
	     				GL11.glVertex3f( 0.3f,SeaLevel+2.6f, 0.7f);         // Bottom Left
	     				GL11.glVertex3f( 0.7f,SeaLevel+2.6f, 0.7f);         // Bottom Right
	     				GL11.glVertex3f( 0.7f,SeaLevel+2.6f, 0.3f);         // Bottom Right
	     				GL11.glVertex3f( 0.3f, SeaLevel+2.6f, 0.3f);         // Top Right
	     			GL11.glEnd();
	     			
	     			GL11.glBegin(GL11.GL_TRIANGLE_FAN);                        // Draw top
	     				GL11.glColor3f(0.99f, 0.61f, 0.01f);
	     				GL11.glVertex3f( 0.5f, SeaLevel+3.6f, 0.5f);         // Top Left
	     				GL11.glColor3f(0.99f, 0.91f, 0.06f);
	 				
	     				GL11.glVertex3f( 0.3f, SeaLevel+2.6f, 0.3f);         // Top Right
	     				GL11.glVertex3f( 0.3f,SeaLevel+2.6f, 0.7f);         // Bottom Left
	     				GL11.glVertex3f( 0.7f,SeaLevel+2.6f, 0.7f);         // Bottom Right
	     				GL11.glVertex3f( 0.7f,SeaLevel+2.6f, 0.3f);         // Bottom Right
	     				GL11.glVertex3f( 0.3f, SeaLevel+2.6f, 0.3f);         // Top Right
	 				GL11.glEnd();
					
					
				}
				Lighting.Activate();
				
				
				}
				
				GroundColour(i*10 + p);
				
				 GL11.glBegin(GL11.GL_QUADS);                        // Draw top
				 	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);         
		            GL11.glVertex3f(0.0f, Height, 0.0f);         // Top Left
		            GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
		            GL11.glVertex3f( 1.0f, Height, 0.0f);         // Top Right
		            GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
		            GL11.glVertex3f( 1.0f,Height, 1.0f);         // Bottom Right
		            GL11.glNormal3f( 0.0f, 1.0f, 0.0f);   
		            GL11.glVertex3f(0.0f,Height, 1.0f);         // Bottom Left
		        GL11.glEnd();      
		        
		        
		        
		        GroundColour(i*10 + p);
		   GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
		   		GL11.glNormal3f( 0.0f, 0.0f, -1.0f);   
	            GL11.glVertex3f(0.0f, Height, 0.0f);         // Top Left
	            GL11.glNormal3f( 0.0f, 0.0f, -1.0f);  
	            GL11.glVertex3f( 1.0f, Height, 0.0f);         // Top Right
	            GL11.glColor3f(0.8f, 0.31f, 0.34f);
	            GL11.glNormal3f( 0.0f, 0.0f, -1.0f);  
	            GL11.glVertex3f(0.0f, -2.0f, 0.0f);         // Top Left
	        GL11.glEnd();   
	        
	        GroundColour(i*10 + p);
	        GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
	        	GL11.glNormal3f( 0.0f, 0.0f, -1.0f);  
            	GL11.glVertex3f( 1.0f, Height, 0.0f);         // Top Right
            	GL11.glColor3f(0.8f, 0.31f, 0.34f);
            	GL11.glNormal3f( 0.0f, 0.0f, -1.0f);  
            	GL11.glVertex3f(0.0f, -2.0f, 0.0f);         // Top Left
            	GL11.glNormal3f( 0.0f, 0.0f, -1.0f);  
            	GL11.glVertex3f( 1.0f, -2.0f, 0.0f);         // Top Right
            GL11.glEnd();   
		        
        
        
            GroundColour(i*10 + p);
				 GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
				 	GL11.glNormal3f( 0.0f, 0.0f, 1.0f);  
		            GL11.glVertex3f( 1.0f,Height, 1.0f);         // Bottom Right
		            GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
		            GL11.glVertex3f(0.0f,Height, 1.0f);         // Bottom Left
		            GL11.glColor3f(0.8f, 0.31f, 0.34f);
		            GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
		            GL11.glVertex3f( 1.0f,-2.0f, 1.0f);         // Bottom Right
		        GL11.glEnd();  
		        
		        GroundColour(i*10 + p);
				 GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
				 	GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
		            GL11.glVertex3f(0.0f,Height, 1.0f);         // Bottom Left
		            GL11.glColor3f(0.8f, 0.31f, 0.34f);
		            GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
		            GL11.glVertex3f( 1.0f,-2.0f, 1.0f);         // Bottom Right
		            GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
		            GL11.glVertex3f(0.0f,-2.0f, 1.0f);         // Bottom Left
		        GL11.glEnd();  
		        
		        
		        GroundColour(i*10 + p);
				 GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
				 	GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f(0.0f, Height, 0.0f);         // Top Left
		            GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f(0.0f,Height, 1.0f);         // Bottom Left
		            GL11.glColor3f(0.8f, 0.31f, 0.34f);
		            GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f(0.0f, -2.0f, 0.0f);         // Top Left
		        GL11.glEnd(); 
		        
		        GroundColour(i*10 + p);
				 GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
				 	GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f(0.0f,Height, 1.0f);         // Bottom Left
		            GL11.glColor3f(0.8f, 0.31f, 0.34f);
		            GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f(0.0f, -2.0f, 0.0f);         // Top Left
		            GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f(0.0f,-2.0f, 1.0f);         // Bottom Left
		        GL11.glEnd(); 
		        
		        
		        GroundColour(i*10 + p);
				 GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
				 	GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f( 1.0f, Height, 0.0f);         // Top Right
		            GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f( 1.0f,Height, 1.0f);         // Bottom Right
		            GL11.glColor3f(0.8f, 0.31f, 0.34f);
		            GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f( 1.0f, -2.0f, 0.0f);         // Top Right
		        GL11.glEnd();
		        
		        GroundColour(i*10 + p);
				 GL11.glBegin(GL11.GL_TRIANGLES);                        // Draw side
				 	GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
				 	GL11.glVertex3f( 1.0f,Height, 1.0f);         // Bottom Right
		            GL11.glColor3f(0.8f, 0.31f, 0.34f);
		            GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f( 1.0f, -2.0f, 0.0f);         // Top Right
		            GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
		            GL11.glVertex3f( 1.0f,-2.0f, 1.0f);         // Bottom Right
		        GL11.glEnd();
		        
		        
		        if (WorldData[i*10 + p] > 2 && WorldData[i*10 + p] < 12){
		        	
		        	tree.Draw(Humidity, Height);
		        	
		        }
		        
		        if (WorldData[i*10 + p] == 17){
		        	
		        	house.Draw(Height);
		        	
		        }
		        
		        if (WorldData[i*10 + p] == -3){
		        	
		        	cropbase.Draw(Height);
		        	crop.Draw(Height, 1);
		        	
		        }
		        
		        if (WorldData[i*10 + p] == -4){
		        	
		        	cropbase.Draw(Height);
		        	crop.Draw(Height, 2);
		        	GL11.glTranslatef(0.0f,0.1f,0.0f);
		        	crop.Draw(Height, 2);
		        	
		        }
 				if (WorldData[i*10 + p] == -5){
 					
 					cropbase.Draw(Height);
 					crop.Draw(Height, 3);
		        	GL11.glTranslatef(0.0f,0.1f,0.0f);
		        	crop.Draw(Height, 3);
		        	GL11.glTranslatef(0.0f,0.1f,0.0f);
		        	crop.Draw(Height, 3);
		        	GL11.glTranslatef(0.0f,0.1f,0.0f);
		        	crop.Draw(Height, 3);
 	
 				}
		        
		        if (WorldData[i*10 + p] == 21){
		        	
		        	house.Draw(Height);
		        	GL11.glTranslatef(0.4f,0.0f,0.0f);
		        	house.Draw(Height);
		        	
		        }
		        
		        if (WorldData[i*10 + p] == 22){
		        	
		        	house.Draw(Height);
		        	GL11.glTranslatef(0.4f,0.0f,0.0f);
		        	house.Draw(Height);
		        	
		        	GL11.glTranslatef(-0.4f,0.0f,0.9f);
		        	GL11.glRotatef(90.0f, 0, 1, 0);
		        	house.Draw(Height);
		        	
		        }
		        
		        if (WorldData[i*10 + p] == 23){
		        	
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);

	        	}
		        if (WorldData[i*10 + p] == 24){
		        	terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		
	        		GL11.glTranslatef(-0.6f,0.0f,0.5f);
	        		terrace.Draw(Height);
	        	}
		        if (WorldData[i*10 + p] == 25){
		        	terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		
	        		GL11.glTranslatef(-0.6f,0.0f,0.5f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        	}
		        if (WorldData[i*10 + p] == 26){
		        	terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		
	        		GL11.glTranslatef(-0.6f,0.0f,0.5f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        		GL11.glTranslatef(0.3f,0.0f,0.0f);
	        		terrace.Draw(Height);
	        	}
		        
		        
		        if (WorldData[i*10 + p] == 27){
		        	apartment.Draw(Height);
		        	GL11.glTranslatef(0.0f,0.2f,0.0f);
		        	apartment.Draw(Height);
		        	GL11.glTranslatef(0.0f,0.2f,0.0f);
		        	apartment.Draw(Height);
		        	
		        }
		        
		        if (WorldData[i*10 + p] > 27 && WorldData[i*10 + p] < 31){
		        	apartment.Draw(Height);
		        	GL11.glTranslatef(0.0f,0.2f,0.0f);
		        	apartment.Draw(Height);
		        	GL11.glTranslatef(0.0f,0.2f,0.0f);
		        	apartment.Draw(Height);
		        	
		        	GL11.glRotatef(180.0f, 0, 1, 0);
		        	GL11.glTranslatef(-1f,-0.4f,-1f);
		        	if (WorldData[i*10 + p] == 28){
		        		apartment.Draw(Height);
		        	}
		        	if (WorldData[i*10 + p] == 29){
		        		apartment.Draw(Height);
			        	GL11.glTranslatef(0.0f,0.2f,0.0f);
			        	apartment.Draw(Height);
		        	}
		        	if (WorldData[i*10 + p] == 30){
		        		apartment.Draw(Height);
			        	GL11.glTranslatef(0.0f,0.2f,0.0f);
			        	apartment.Draw(Height);
			        	GL11.glTranslatef(0.0f,0.2f,0.0f);
			        	apartment.Draw(Height);
		        	}
		        	
		        
		        	
		        }
		        
		        if (WorldData[i*10 + p] == 31){
		        	
		        	tower.Draw(Height);
		        	
		        }

		        
		        GL11.glLoadIdentity();
		        GL11.glTranslatef(0.0f,0.0f,-20.0f);
		        GL11.glRotatef(Orientation, 1, 0, 0);
		        GL11.glRotatef(Rotation, 0, 1, 0);
		        
		        if (Quake == 1){
					GL11.glTranslatef((float)Math.sin(QuakeTimer)/8 ,0.0f, (float)Math.sin(QuakeTimer/2)/8); 
				}
		       
		            
			
			}
			



		}
		
		 //lighting
        float lightAmbient[] = { TimeOfDay, TimeOfDay, TimeOfDay, 1.0f };
    	float lightDiffuse[] = { 0.5f, 0.5f, 0.5f, 1.0f };
        float lightPosition[] = { 0.0f, 40.0f, -15.0f, 0.0f };
        
        ByteBuffer temp = ByteBuffer.allocateDirect(16);
        temp.order(ByteOrder.nativeOrder());
        
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, (FloatBuffer)temp.asFloatBuffer().put(lightAmbient).flip());              // Setup The Ambient Light
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, (FloatBuffer)temp.asFloatBuffer().put(lightDiffuse).flip());              // Setup The Diffuse Light
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION,(FloatBuffer)temp.asFloatBuffer().put(lightPosition).flip());  
		
		//WATER
        GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, 70);
		 GL11.glBegin(GL11.GL_QUADS);                        // Draw top
		 	GL11.glColor4f(0.53f, 0.81f, 0.92f, 0.7f);
		 	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
		 	GL11.glVertex3f(-8.35f, SeaLevel + 0.05f, -8.35f);         // Top Left
		 	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
		 	GL11.glVertex3f( 8.35f, SeaLevel + 0.05f, -8.35f);         // Top Right
		 	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
		 	GL11.glVertex3f( 8.35f, SeaLevel + 0.05f, 8.35f);         // Bottom Right
		 	GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
		 	GL11.glVertex3f(-8.35f, SeaLevel + 0.05f, 8.35f);         // Bottom Left
         GL11.glEnd();
         
	 
	}
	
	public static void ParticleDraw(){
		
		Lighting.DeActivate();
		GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f,0.0f,-20.0f);
        GL11.glRotatef(Orientation, 1, 0, 0);
        GL11.glRotatef(Rotation, 0, 1, 0);
        
        if (Quake == 1){
			GL11.glTranslatef((float)Math.sin(QuakeTimer)/8 ,0.0f, (float)Math.sin(QuakeTimer/2)/8); 
		}
		
		for (int i = 0; i < 10; i++){

			
			for (int p = 0; p < 10; p++){
				
				Height = WorldHeight[i*10 + p];
				GL11.glTranslatef(1.0f * i, 0.0f ,0.0f);  
				GL11.glTranslatef(0.0f ,0.0f, 1.0f * p); 
				
				GL11.glTranslatef(-5.0f ,0.0f, -5.0f); 
				
				
				
				GL11.glRotatef(90*WorldRotate[i*10 + p], 0, 1, 0);
				if (WorldRotate[i*10 + p] == 1){
					GL11.glTranslatef(-1.0f ,0.0f, 0.0f); 
				}
				if (WorldRotate[i*10 + p] == 2){
					GL11.glTranslatef(-1.0f ,0.0f, -1.0f); 
				}
				if (WorldRotate[i*10 + p] == 3){
					GL11.glTranslatef( 0.0f ,0.0f, -1.0f); 
				}
				
				
				
				if (WorldEffect[i*10 + p] == 2){
					cloud.Draw(Height, 1);
				}
				if (WorldEffect[i*10 + p] == 3){
					cloud.Draw(Height, 2);
				}
				
				if (WorldParticleTimer[i*10 + p][0] == 1){
				
					Particle.DrawCircle(Height);
				}
				
				
				GL11.glLoadIdentity();
		        GL11.glTranslatef(0.0f,0.0f,-20.0f);
		        GL11.glRotatef(Orientation, 1, 0, 0);
		        GL11.glRotatef(Rotation, 0, 1, 0);
		        if (Quake == 1){
					GL11.glTranslatef((float)Math.sin(QuakeTimer)/8 ,0.0f, (float)Math.sin(QuakeTimer/2)/8); 
				}
				
				
			}
		}
		
		
		
	}
	
	public static void UIDraw(){
		

		
		Lighting.DeActivate();
		GL11.glDisable ( GL11.GL_LIGHTING );
	          MyFont.Print("Population: " + Population, -1.55f, 1.15f);     // Print GL Text To The Screen
	          
	          //MyFont.Print("Pollution: " + Pollution, -1.55f, 1.1f);     // Print GL Text To The Screen
	          
	          if (Pollution == 0){
	        	  MyFont.Print("No Pollution", -1.55f, 1.0f, 0.95f, 0.94f, 0.27f);     // Print GL Text To The Screen
	          }
	          if (Pollution > 0 && Pollution <= 20000){
	        	  MyFont.Print("Low Pollution", -1.55f, 1.0f, 0.95f, 0.94f, 0.27f);     // Print GL Text To The Screen
	          }
	          if (Pollution > 20000 && Pollution <= 40000){
	        	  MyFont.Print("Moderate Pollution", -1.55f, 1.0f, 1.0f, 0.64f, 0.0f);     // Print GL Text To The Screen
	          }
	          if (Pollution > 40000 && Pollution <= 60000){
	        	  MyFont.Print("High Pollution", -1.55f, 1.0f, 1.0f, 0.64f, 0.0f);     // Print GL Text To The Screen
	          }
	          if (Pollution > 60000 && Pollution <= 80000){
	        	  MyFont.Print("Very High Pollution", -1.55f, 1.0f, 1.0f, 0.0f, 0.0f);     // Print GL Text To The Screen
	          }
	          if (Pollution > 80000){
	        	  MyFont.Print("Dangerous Pollution", -1.55f, 1.0f, 1.0f, 0.0f, 0.0f);     // Print GL Text To The Screen
	          }
	          
	          if (won == true){
	        	  MyFont.Print("Perfect Society Achieved", -0.6f, 0.8f, 1.0f, 0.0f, 1.0f);     // Print GL Text To The Screen
	          }
	          
	          
	          MyFont.Print("Food: " + Food, -1.55f, 1.08f);     // Print GL Text To The Screen
	          
	          
	          //bars
	          MyFont.Print("Humidity", -0.9f, 2.0f, -5.0f);     // Print GL Text To The Screen
	          MyFont.Print("Faith", 0.7f, 2.0f, -5.0f);     // Print GL Text To The Screen

		     	GL11.glDisable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
	          
		     	 GL11.glLoadIdentity();
		         GL11.glTranslatef(-1.55f,2.2f,-6.0f); 
		         
		         GL11.glColor3f(0.0f, 0.0f, 0.0f);
	        	 GL11.glBegin(GL11.GL_QUADS);      
		         	GL11.glVertex3f( 2.0f, 0.15f, 0.0f);         // Top Left
	             	GL11.glVertex3f( 3.0f, 0.15f, 0.0f);         // Top Right
	             	GL11.glVertex3f( 3.0f, -0.05f, 0.0f);         // Bottom Right
	             	GL11.glVertex3f( 2.0f, -0.05f, 0.0f);         // Bottom Left
	             GL11.glEnd();
		         
		         GL11.glColor3f(1.0f, 1.0f, 1.0f);
	        	 GL11.glBegin(GL11.GL_QUADS);      
	        	 	GL11.glVertex3f( 0.0f, 0.15f, 0.0f);         // Top Left
	        	 	GL11.glVertex3f( 1.6f, 0.15f, 0.0f);         // Top Right
	        	 	GL11.glVertex3f( 1.6f, -0.05f, 0.0f);         // Bottom Right
	        	 	GL11.glVertex3f( 0.0f, -0.05f, 0.0f);         // Bottom Left
	             GL11.glEnd();
	             
	             GL11.glBegin(GL11.GL_QUADS); 
	             	GL11.glVertex3f( 2.0f, 0.15f, 0.0f);         // Top Left
	             	GL11.glVertex3f( 2.0f + 0.01f * Faith, 0.15f, 0.0f);         // Top Right
	             	GL11.glVertex3f( 2.0f + 0.01f * Faith, -0.05f, 0.0f);         // Bottom Right
	             	GL11.glVertex3f( 2.0f, -0.05f, 0.0f);         // Bottom Left
	             GL11.glEnd();

		         
		         if (Humidity > 0){
		        	 GL11.glColor3f(0.0f, 0.0f, 1.0f);
		        	 GL11.glBegin(GL11.GL_QUADS);      
		        	 	GL11.glVertex3f( 0.8f, 0.15f, 0.0f);         // Top Left
		        	 	GL11.glVertex3f( 0.8f +0.1f * Humidity, 0.15f, 0.0f);         // Top Right
		        	 	GL11.glVertex3f( 0.8f +0.1f * Humidity, -0.05f, 0.0f);         // Bottom Right
		        	 	GL11.glVertex3f( 0.8f, -0.05f, 0.0f);         // Bottom Left
		             GL11.glEnd();
		         }
		         
		         if (Humidity < 0){
		        	 GL11.glColor3f(1.0f, 0.0f, 0.0f);
		        	 GL11.glBegin(GL11.GL_QUADS);      
		        	 	GL11.glVertex3f( 0.8f + (0.1f * Humidity), 0.15f, 0.0f);         // Top Left
		        	 	GL11.glVertex3f( 0.8f,  0.15f, 0.0f);         // Top Right
		        	 	GL11.glVertex3f( 0.8f, -0.05f, 0.0f);         // Bottom Right
		        	 	GL11.glVertex3f( 0.8f + (0.1f * Humidity), -0.05f, 0.0f);         // Bottom Left
		             GL11.glEnd();
		         }
		         
		     	GL11.glColor3f(0.0f, 0.0f, 0.0f);
		        // GL11.glTranslatef(0.0f,0.0f,0.0f);              // Move Right 3 Units
		         GL11.glBegin(GL11.GL_QUADS);                        // Draw A Quad

		             GL11.glVertex3f( 0.0f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 1.6f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 1.6f, 0.14f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.0f, 0.14f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.0f, -0.04f, 0.0f);         // Top Left
		             GL11.glVertex3f( 1.6f, -0.04f, 0.0f);         // Top Right
		             GL11.glVertex3f( 1.6f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.0f, -0.05f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.0f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 0.01f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 0.01f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.0f, -0.05f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 1.59f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 1.6f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 1.6f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 1.59f, -0.05f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.79f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 0.81f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 0.81f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.79f, -0.05f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.59f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 0.61f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 0.61f, 0.07f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.59f, 0.07f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.39f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 0.41f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 0.41f, 0.07f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.39f, 0.07f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.19f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 0.21f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 0.21f, 0.07f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.19f, 0.07f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 0.99f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 1.01f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 1.01f, 0.07f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 0.99f, 0.07f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 1.19f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 1.21f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 1.21f, 0.07f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 1.19f, 0.07f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 1.39f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 1.41f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 1.41f, 0.07f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 1.39f, 0.07f, 0.0f);         // Bottom Left
		             
		             
		             
		            
		             //faith box
		             GL11.glVertex3f( 2.0f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 3.0f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 3.0f, 0.14f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 2.0f, 0.14f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 2.0f, -0.04f, 0.0f);         // Top Left
		             GL11.glVertex3f( 3.0f, -0.04f, 0.0f);         // Top Right
		             GL11.glVertex3f( 3.0f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 2.0f, -0.05f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 2.0f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 2.01f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 2.01f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 2.0f, -0.05f, 0.0f);         // Bottom Left
		             
		             GL11.glVertex3f( 2.99f, 0.15f, 0.0f);         // Top Left
		             GL11.glVertex3f( 3.01f, 0.15f, 0.0f);         // Top Right
		             GL11.glVertex3f( 3.01f, -0.05f, 0.0f);         // Bottom Right
		             GL11.glVertex3f( 2.99f, -0.05f, 0.0f);         // Bottom Left

		         GL11.glEnd();      

		        GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
	          
	          
	          if (SelectActive == false){
	        	  MyFont.Print("Q - Rotate Left. ", -1.55f, -0.8f);     // Print GL Text To The Screen
	        	  MyFont.Print("E - Rotate Right. ", -1.55f, -0.9f);     // Print GL Text To The Screen
	        	  MyFont.Print("W - Rotate Up. ", -1.55f, -1.0f);     // Print GL Text To The Screen
	        	  MyFont.Print("S - Rotate Down. ", -1.55f, -1.1f);     // Print GL Text To The Screen
	        	  MyFont.Print("Z - Activate Selection. ", -1.55f, -1.2f);     // Print GL Text To The Screen
	          }
	          
	          if (SelectActive == true && SpellSelect == false){
	        	  MyFont.Print("A - Select Tile. ", -1.55f, -0.7f);     // Print GL Text To The Screen
	        	  MyFont.Print("Q - Move Selection Left. ", -1.55f, -0.8f);     // Print GL Text To The Screen
	        	  MyFont.Print("E - Move Selection Right. ", -1.55f, -0.9f);     // Print GL Text To The Screen
	        	  MyFont.Print("W - Move Selection Up. ", -1.55f, -1.0f);     // Print GL Text To The Screen
	        	  MyFont.Print("S - Move Selection Down. ", -1.55f, -1.1f);     // Print GL Text To The Screen
	        	  MyFont.Print("Z - Deactivate Selection. ", -1.55f, -1.2f);     // Print GL Text To The Screen
	          }
	          
	          if (SpellSelect == true && SelectActive == true && WhichSpell == 0){
	        	  //MyFont.Print("A - Select Tile. ", -1.55f, -0.7f);     // Print GL Text To The Screen
	        	  MyFont.Print("Q - Land Miracle. ", -1.55f, -0.8f);     // Print GL Text To The Screen
	        	  MyFont.Print("E - Life Miracle. ", -1.55f, -0.9f);     // Print GL Text To The Screen
	        	  MyFont.Print("W - Weather Miracle. ", -1.55f, -1.0f);     // Print GL Text To The Screen
	        	  MyFont.Print("S - Deselect Tile. ", -1.55f, -1.1f);     // Print GL Text To The Screen
	        	  MyFont.Print("Z - Deactivate Selection. ", -1.55f, -1.2f);     // Print GL Text To The Screen
	          }
	          
	          if (SpellSelect == true && SelectActive == true && WhichSpell == 1){
	        	  //MyFont.Print("A - Select Tile. ", -1.55f, -0.7f);     // Print GL Text To The Screen
	        	  MyFont.Print("Q - Lower Land. ", -1.55f, -0.8f);     // Print GL Text To The Screen
	        	  MyFont.Print("E - Raise land. ", -1.55f, -0.9f);     // Print GL Text To The Screen
	        	  MyFont.Print("W - Cleanse Land. ", -1.55f, -1.0f);     // Print GL Text To The Screen
	        	  MyFont.Print("S - Cancel. ", -1.55f, -1.1f);     // Print GL Text To The Screen
	        	  MyFont.Print("Z - Deactivate Selection. ", -1.55f, -1.2f);     // Print GL Text To The Screen
	          }
	          
	          if (SpellSelect == true && SelectActive == true && WhichSpell == 2){
	        	  //MyFont.Print("A - Select Tile. ", -1.55f, -0.7f);     // Print GL Text To The Screen
	        	  MyFont.Print("Q - Summon HeatWave. ", -1.55f, -0.8f);     // Print GL Text To The Screen
	        	  MyFont.Print("E - Summon Storm. ", -1.55f, -0.9f);     // Print GL Text To The Screen
	        	  MyFont.Print("W - Summon Rain. ", -1.55f, -1.0f);     // Print GL Text To The Screen
	        	  MyFont.Print("S - Cancel. ", -1.55f, -1.1f);     // Print GL Text To The Screen
	        	  MyFont.Print("Z - Deactivate Selection. ", -1.55f, -1.2f);     // Print GL Text To The Screen
	          }
	          
	          if (SpellSelect == true && SelectActive == true && WhichSpell == 3){
	        	  //MyFont.Print("A - Select Tile. ", -1.55f, -0.7f);     // Print GL Text To The Screen
	        	  MyFont.Print("Q - Plant Tree. ", -1.55f, -0.8f);     // Print GL Text To The Screen
	        	  MyFont.Print("E - Plant Crop. ", -1.55f, -0.9f);     // Print GL Text To The Screen
	        	  MyFont.Print("W - Create Human. ", -1.55f, -1.0f);     // Print GL Text To The Screen
	        	  MyFont.Print("S - Cancel. ", -1.55f, -1.1f);     // Print GL Text To The Screen
	        	  MyFont.Print("Z - Deactivate Selection. ", -1.55f, -1.2f);     // Print GL Text To The Screen
	          }
	          
	          
	          //MyFont.Print("Polluted: " + Polluted, -1.55f, -1.2f);     // Print GL Text To The Screen
	          //GL11.glEnable ( GL11.GL_LIGHTING );
	}
	
	public static void GroundColour(int i){
		if (WorldData[i] != -2){
			if (Humidity > -5){
				GL11.glColor3f(0.74f, 0.85f, 0.34f);
			}
			if (Humidity == -5){
				GL11.glColor3f(0.78f, 0.87f, 0.44f);
			}
			if (Humidity == -6){
				GL11.glColor3f(0.85f, 0.91f, 0.62f);
			}
			if (Humidity < -6){
				GL11.glColor3f(0.91f, 0.95f, 0.75f);
			}
		}
		if (WorldEffect[i] == 1){
			GL11.glColor3f(0.91f, 0.95f, 0.75f);
		}
		if (WorldData[i] == -2){
			GL11.glColor3f(1.0f, 0.73f, 0.0f);
		}
		
	}
	
	public static void WorldUpdate(){
	// victory
		if (Population > 350 && Starve == false && Age == 3){
			
			won = true;
		}
		if (won == true){
			wintimer++;
		}
		if (wintimer > 500){
			GenerateWorld();
		}
	//rain
		cloud.RainUpdate();
	// particles
		Particle.Update();
		
	//ages
		if (Population > 40 && Age == 0){
			Age = 1;
			PollutionMultiplier = 1.5f;
		}
		if (Population > 120 && Age == 1){
			Age = 2;
			FoodMultiplier = 1.2f;
		}
		if (Population > 220 && Age == 2){
			Age = 3;
			PopulationMultiplier = 1.5f;
		}
	//food
		FoodTimer += 0.01f;
		if (FoodTimer > 20){
			Food -= Population * FoodMultiplier;
			FoodTimer = 0;
		}
		if (Food < 0){
			Food = 0;
		}
		if (Food <= 0){
			StarvationTimer += 0.01f;
		}
		if (StarvationTimer > 50){
			Starve = true;
		}
		if (Food > Population + 90){
			Starve = false;
			StarvationTimer = 0.0f;
		}
		
	//faith
		if (Faith > 100){
			Faith = 100;
		}
		if (Faith < 0){
			Faith = 0;
		}
		
		
	//select box
		//activation
		if (Input.GetZ() == true && SelectActive == false && SelectSwitch == false){
			SelectSwitch = true;
		}
		if (Input.GetZ() == false && SelectActive == false && SelectSwitch == true){
			SelectActive = true;
			SelectSwitch = false;
		}
		if (Input.GetZ() == true && SelectActive == true && SelectSwitch == false){
			SelectSwitch = true;
		}
		if (Input.GetZ() == false && SelectActive == true && SelectSwitch == true){
			SelectActive = false;
			SelectSwitch = false;
			SpellSelect = false;
			WhichSpell = 0;
		}
		//movement
		if (Input.GetQ() == true && QSwitch == false && SelectActive == true && SpellSelect == false){
			QSwitch = true;
		}
		if (Input.GetQ() == false && QSwitch == true && SelectActive == true && SpellSelect == false){
			if (Rotation >= 45 && Rotation < 135){
				if(SelectBox > 0){
					SelectBox -= 1;
				}
			}
			if (Rotation > 315 || Rotation < 45){
				if(SelectBox > 9){
					SelectBox -= 10;
				}
			}
			if (Rotation >= 135 && Rotation < 225){
				if(SelectBox < 90){
					SelectBox += 10;
				}
			}
			if (Rotation >= 225 && Rotation < 315){
				if(SelectBox < 99){
					SelectBox += 1;
				}
			}
			QSwitch = false;
		}
		if (Input.GetE() == true && ESwitch == false && SelectActive == true && SpellSelect == false){
			ESwitch = true;
		}
		if (Input.GetE() == false && ESwitch == true && SelectActive == true && SpellSelect == false){
			if (Rotation >= 45 && Rotation < 135){
				if(SelectBox < 99){
					SelectBox += 1;
				}
			}
			if (Rotation > 315 || Rotation < 45){
				if(SelectBox < 90){
					SelectBox += 10;
				}
			}
			if (Rotation >= 135 && Rotation < 225){
				if(SelectBox > 9){
					SelectBox -= 10;
				}
			}
			if (Rotation >= 225 && Rotation < 315){
				if(SelectBox > 0){
					SelectBox -= 1;
				}
			}
			ESwitch = false;
		}
		if (Input.GetW() == true && WSwitch == false && SelectActive == true && SpellSelect == false){
			WSwitch = true;
		}
		if (Input.GetW() == false && WSwitch == true && SelectActive == true && SpellSelect == false){
			if (Rotation >= 45 && Rotation < 135){
				if(SelectBox < 90){
					SelectBox += 10;
				}
			}
			if (Rotation > 315 || Rotation < 45){
				if(SelectBox > 0){
					SelectBox -= 1;
				}
			}
			if (Rotation >= 135 && Rotation < 225){
				if(SelectBox < 99){
					SelectBox += 1;
				}
			}
			if (Rotation >= 225 && Rotation < 315){
				if(SelectBox > 9){
					SelectBox -= 10;
				}
			}
			WSwitch = false;
		}
		if (Input.GetS() == true && SSwitch == false && SelectActive == true && SpellSelect == false){
			SSwitch = true;
		}
		if (Input.GetS() == false && SSwitch == true && SelectActive == true && SpellSelect == false){
			if (Rotation >= 45 && Rotation < 135){
				if(SelectBox > 9){
					SelectBox -= 10;
				}
			}
			if (Rotation > 315 || Rotation < 45){
				if(SelectBox < 99){
					SelectBox += 1;
				}
			}
			if (Rotation >= 135 && Rotation < 225){
				if(SelectBox > 0){
					SelectBox -= 1;
				}
			}
			if (Rotation >= 225 && Rotation < 315){
				if(SelectBox < 90){
					SelectBox += 10;
				}
			}
			SSwitch = false;
		}
		//spell select
		if (Input.GetA() == true && SelectActive == true && ASwitch == false && SpellSelect == false && WhichSpell == 0){
			ASwitch = true;
		}
		if (Input.GetA() == false && SelectActive == true && ASwitch == true && SpellSelect == false && WhichSpell == 0){
			SpellSelect = true;
			ASwitch = false;
		}
		if (Input.GetS() == true && SelectActive == true && SSwitch == false && SpellSelect == true && WhichSpell == 0){
			SSwitch = true;
		}
		if (Input.GetS() == false && SelectActive == true && SSwitch == true && SpellSelect == true && WhichSpell == 0){
			SpellSelect = false;
			SSwitch = false;
		}
		if (Input.GetQ() == true && SelectActive == true && QSwitch == false && SpellSelect == true && WhichSpell == 0){
			QSwitch = true;
		}
		if (Input.GetQ() == false && SelectActive == true && QSwitch == true && SpellSelect == true && WhichSpell == 0){
			WhichSpell = 1;
			QSwitch = false;
		}
		if (Input.GetE() == true && SelectActive == true && ESwitch == false && SpellSelect == true && WhichSpell == 0){
			ESwitch = true;
		}
		if (Input.GetE() == false && SelectActive == true && ESwitch == true && SpellSelect == true && WhichSpell == 0){
			WhichSpell = 3;
			ESwitch = false;
		}
		if (Input.GetW() == true && SelectActive == true && WSwitch == false && SpellSelect == true && WhichSpell == 0){
			WSwitch = true;
		}
		if (Input.GetW() == false && SelectActive == true && WSwitch == true && SpellSelect == true && WhichSpell == 0){
			WhichSpell = 2;
			WSwitch = false;
		}
		//spell effects
		if (WhichSpell > 0){
			if (Input.GetS() == true && SelectActive == true && SSwitch == false && SpellSelect == true){
				SSwitch = true;
			}
			if (Input.GetS() == false && SelectActive == true && SSwitch == true && SpellSelect == true){
				WhichSpell = 0;
				SSwitch = false;
			}
			if (Input.GetQ() == true && SelectActive == true && QSwitch == false && SpellSelect == true){
				QSwitch = true;
			}
			if (Input.GetQ() == false && SelectActive == true && QSwitch == true && SpellSelect == true){
				if (WhichSpell == 1 && Faith >= 5){
					WorldHeight[SelectBox]-= 0.1f;
					Faith -= 5;
				}
				if (WhichSpell == 2 && Faith >= 10){
					ApplyWeather(SelectBox, 1);
					if ((WorldData[SelectBox] > 2 && WorldData[SelectBox] < 12) || WorldData[SelectBox] < -2){
						WorldData[SelectBox] = 0;
					}
					Faith -= 10;
					
				}
				if (WhichSpell == 3 && Faith >= 15){
					if (WorldData[SelectBox] != -2){
						WorldData[SelectBox] = 8;
						Faith -= 15;
					}
				}
				SelectActive = false;
				SelectSwitch = false;
				SpellSelect = false;
				WhichSpell = 0;
				QSwitch = false;
			}
			if (Input.GetE() == true && SelectActive == true && ESwitch == false && SpellSelect == true){
				ESwitch = true;
			}
			if (Input.GetE() == false && SelectActive == true && ESwitch == true && SpellSelect == true){
				if (WhichSpell == 1 && Faith >= 5){
					WorldHeight[SelectBox]+= 0.1f;
					Faith -= 5;
				}
				if (WhichSpell == 2 && Faith >= 10){
					Faith -= 10;
					ApplyWeather(SelectBox, 3);
				}
				if (WhichSpell == 3 && Faith >= 10){
					if ((WorldData[SelectBox] > -1 && WorldData[SelectBox] < 3) || (WorldData[SelectBox] > 11 && WorldData[SelectBox] < 20 && WorldData[SelectBox] != 17)){
						Faith -= 10;
						WorldData[SelectBox] = -3;
					}
	
				}
				SelectActive = false;
				SelectSwitch = false;
				SpellSelect = false;
				WhichSpell = 0;
				ESwitch = false;
			}
			if (Input.GetW() == true && SelectActive == true && WSwitch == false && SpellSelect == true){
				WSwitch = true;
			}
			if (Input.GetW() == false && SelectActive == true && WSwitch == true && SpellSelect == true){
				if (WhichSpell == 1 && Faith >= 30){
					if (WorldData[SelectBox] == -2){
						WorldData[SelectBox] = 1;
						Faith -= 30;
					}
				}
				if (WhichSpell == 2 && Faith >= 5){
					Faith -= 5;
					ApplyWeather(SelectBox, 2);
				}
				if (WhichSpell == 3 && Faith >= 20){
					Faith -= 20;
					if (WorldData[SelectBox] != -2){
						if (WorldData[SelectBox] == 17){
							WorldData[SelectBox] = 21;
							WorldParticleTimer[SelectBox][0] = 1;
							WorldParticleTimer[SelectBox][1] = 100;
						}
						else if (WorldData[SelectBox] > 20){
							WorldData[SelectBox] ++;
							WorldParticleTimer[SelectBox][0] = 1;
							WorldParticleTimer[SelectBox][1] = 100;
						}
						else {
							WorldData[SelectBox] = 17;
							WorldParticleTimer[SelectBox][0] = 1;
							WorldParticleTimer[SelectBox][1] = 100;
						}
					}
				}
				SelectActive = false;
				SelectSwitch = false;
				SpellSelect = false;
				WhichSpell = 0;
				WSwitch = false;
			}
	
		}
		
	//time of day
		if (TimeSwitch == 0){
		TimeOfDay += 0.0001f;
		}
		if (TimeSwitch == 1){
			TimeOfDay -= 0.0001f;
		}
		if (TimeOfDay > 1){
			TimeOfDay = 1;
			TimeSwitch = 1;
		}
		if (TimeOfDay < 0){
			TimeOfDay = 0;
			TimeSwitch = 0;
		}
		//if (TimeOfDay > 0.5f){
			GL11.glClearColor(0.0f, 0.8f, 1.0f, 0.0f);
		//}
		/*if (TimeOfDay < 0.5f){
			GL11.glClearColor(0.0f, 0.0f, 1f, TimeOfDay*1.5f+0.5f);
		}*/
	
	
	//pollution
			if (Pollution < 100000){
				Pollution += Population * PollutionMultiplier;
			}
			Pollution -= 1;
			if (Humidity > -4){
				Pollution -= Trees * 20;
			}
			if (Pollution < 0){
				Pollution = 0;
			}
			if (Pollution > 80000){
				PollutionTimer += 0.1f;
			}
			if (PollutionTimer > 50){
				Temp = randomGenerator.nextInt(100);
				WorldData[Temp] = -2;
				PollutionTimer = 0;
			}
			
	//earthquake
		if (Input.GetSpace() == true && Quake == 0){
			Quake = 1;
			for (int i = 0; i <100; i++){
				
				if (WorldData[i] == 17){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldData[i] = 16;
				}
				if (WorldData[i] == 21){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldData[i] = 17;
				}
				if (WorldData[i] > 21 && WorldData[i] < 23){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldData[i] --;
				}
				
				if (WorldData[i] > 22){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					Temp = randomGenerator.nextInt(WorldData[i] - 22) + 1;
					WorldData[i] -= Temp;
				}
				
				
				if (WorldData[i] > 2 && WorldData[i] < 12){
					Temp = randomGenerator.nextInt(5);
					if (Temp > 2){
						WorldData[i] = 1;
						WorldTimer[i] = -(randomGenerator.nextInt(200));
					}
				}
				
				
			}
		}
		if (Quake == 1){
			QuakeTimer += 0.15f;
		}
		if (QuakeTimer > 50){
			Quake = 0;
			QuakeTimer = 0;
		}
		
			
	//sea level
			//SeaLevel -= 0.01f;
			if(Humidity < 0){
				if (SeaLevel < SeaBase){
					SeaLevel += 0.005f;
				}
				else {
					if (SeaLevel != SeaBase){
						SeaLevel -= 0.005f;
					}
				}
			}
			if (Humidity > 0){
				
				SeaHeight = -0.2f + Humidity * 0.1f;
				
				if (SeaLevel > SeaHeight){
					SeaLevel -= 0.005f;
				}
				else {
					if (SeaLevel != SeaHeight){
						SeaLevel += 0.005f;
					}
				}
			}
			
	//Humidity
			if (Input.GetR() == true){
				RSwitch = 1;
			}
			if (RSwitch == 1 && Input.GetR() == false){
				Humidity ++; 
				RSwitch = 0;
			}
			if (Humidity > 8){
				Humidity = 8;
			}
	//Drought
			if (Input.GetD() == true){
				DSwitch = 1;
			}
			if (DSwitch == 1 && Input.GetD() == false){
				Humidity --; 
				DSwitch = 0;
			}
			if (Humidity < -8){
				Humidity = -8;
			}
			if (Humidity > -2){
				SeaBase = -0.3f;
			}
			if (Humidity == -3){
				SeaBase = -0.5f;
			}
			if (Humidity == -4){
				SeaBase = -0.7f;
			}
			if (Humidity == -5){
				SeaBase = -0.9f;
			}
			if (Humidity == -6){
				SeaBase = -1.1f;
			}
			if (Humidity == -7){
				SeaBase = -1.3f;
			}
			if (Humidity == -8){
				SeaBase = -1.5f;
			}
			
		
	//world rotation
		if (Input.GetE() == true && SelectActive == false){
			Rotation += 0.5f;
		}
		
		if (Input.GetQ() == true && SelectActive == false){
			Rotation -= 0.5f;
		}
		if (Rotation > 360){
			Rotation = 0;
		}
		if (Rotation < 0){
			Rotation = 360;
		}
		
	//world orientation
		if (Input.GetW() == true && SelectActive == false){
			Orientation += 0.5f;
		}
		
		if (Input.GetS() == true && SelectActive == false){
			Orientation -= 0.5f;
		}
		
		if (Orientation < 25.0f){
			Orientation = 25.0f;
		}
		
		if (Orientation > 60.0f){
			Orientation = 60.0f;
		}
		
	//regenerate
		if (Input.GetG() == true){
			GenSwitch = 1;
		}
		if (GenSwitch == 1 && Input.GetG() == false){
			
			GenerateWorld();
			GenSwitch = 0;
		}
		
		OldPopulation = Population;
		Population = 0;
		Trees = 0;
		Polluted = 0;
		for (int i = 0; i <100; i++){
			// particle time out
			
			if (WorldParticleTimer[i][1] > 0){
				WorldParticleTimer[i][1] --;
			}
			if (WorldParticleTimer[i][1] <= 0){
				WorldParticleTimer[i][0] = 0;
			}
			
			
			
			//starvation
			if (Starve == true){
				if (WorldTimer[i] > 90){
					if (WorldData[i] == 17){
						WorldData[i] = 16;
						WorldTimer[i] = -(randomGenerator.nextInt(200));
					}
					if (WorldData[i] == 21){
						WorldData[i] = 17;
						WorldTimer[i] = -(randomGenerator.nextInt(200));
					}
					if (WorldData[i] > 21){
						WorldData[i]--;
						WorldTimer[i] = -(randomGenerator.nextInt(200));
					}
				}
			}
			
			//crop growth
			if ((WorldHeight[i] * 10 == Humidity - 1) || WorldEffect[i] == 2){
				TempMultiplier = 3;
			}
			
			
			if (WorldData[i] > -6 && WorldData[i] < -2 && Humidity > -4){
				WorldTimer[i] +=0.01f * TempMultiplier;
			}
			if (WorldData[i] == -3 && WorldTimer[i] > 20){
				WorldTimer[i] = -(randomGenerator.nextInt(50));
				WorldData[i] = -4;
			}
			if (WorldData[i] == -4 && WorldTimer[i] > 20){
				WorldTimer[i] = -(randomGenerator.nextInt(50));
				WorldData[i] = -5;
			}
			if (WorldData[i] == -5 && WorldTimer[i] > 20){
				WorldTimer[i] = -(randomGenerator.nextInt(50));
				Food += 60;
				Faith += 1;
				WorldData[i] = -3;
			}
			TempMultiplier = 1;
			
			//effects			effects: 1 - heat wave    2 - rain	3 - storm
			if (WorldEffect[i] > 0){
				WorldEffectTimer[i] += 0.01f;
			}
			if (WorldEffect[i] == 1){
				if((WorldData[i] > 2 && WorldData[i] < 12) || WorldData[i] < -2){
					WorldData[i] = 0;
				}
				if (WorldEffectTimer[i] > 100){
					WorldEffectTimer[i] = 0.0f;
					WorldEffect[i] = 0;
				}
				WorldTimer[i] = -(randomGenerator.nextInt(200));
			}
			if (WorldEffect[i] > 1){
				if (WorldEffectTimer[i] > 100){
					WorldEffectTimer[i] = 0.0f;
					WorldEffect[i] = 0;
				}
			}
			if (WorldEffect[i] == 3 && WorldData[i] < -2){
				WorldData[i] = 1;
			}
			
			//tree growth
			if ((WorldData[i] > -1 && WorldData[i] < 3) || (WorldData[i] > 11 && WorldData[i] < 20 && WorldData[i] != 17)){
				if ((WorldHeight[i] * 10 == Humidity - 1) || WorldEffect[i] > 1){
					WorldTimer[i] += 0.05f;
				
					if (WorldTimer[i] > 100){
						WorldData[i] = 8;
					}
				}
				if (Humidity < 0 && WorldEffect[i] == 0){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
				}
			}
			//tree death
			if (WorldData[i] > 2 && WorldData[i] < 12){
				if (Humidity > -4){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
				}
				else { WorldTimer[i] += 0.05f; }
				if (WorldTimer[i] > 100){
					WorldData[i] = 2;
				}
			}
			
			//population
			if (WorldData[i] == 17){
				Population++;
			}
			if (WorldData[i] == 21){
				Population+=2;
			}
			if (WorldData[i] == 22){
				Population+=3;
			}
			if (WorldData[i] == 23){
				Population+=3;
			}
			if (WorldData[i] == 24){
				Population+=4;
			}
			if (WorldData[i] == 25){
				Population+=5;
			}
			if (WorldData[i] == 26){
				Population+=6;
			}
			if (WorldData[i] == 27){
				Population+=6;
			}
			if (WorldData[i] == 28){
				Population+=8;
			}
			if (WorldData[i] == 29){
				Population+=10;
			}
			if (WorldData[i] == 30){
				Population+=12;
			}
			if (WorldData[i] == 31){
				Population+=14;
			}
			//tree population
			if (WorldData[i] > 2 && WorldData[i] < 12){
				Trees++;
			}
			
			//pollution
			if (WorldData[i] == -2){
				Polluted++;
			}
			
			//flooding
			if ((WorldData[i] > -1 && WorldData[i] < 3) || WorldData[i] > 11 || WorldData[i] < -2){
				if (SeaLevel + 0.01f > WorldHeight[i]){
					WorldData[i] = 0;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
				}
			}	
		
			if (WorldData[i] > 2 && WorldData[i] < 12){
				if (SeaLevel + 0.01f > WorldHeight[i] + 0.3f){
					WorldData[i] = 0;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
				}
			}	
			
			//population expansion
			if (WorldData[i] == 17){
				WorldTimer[i] += 0.05f;
				if (WorldTimer[i] > 100 * PopulationMultiplier){
					WorldData[i] = 21;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldParticleTimer[i][0] = 1;
					WorldParticleTimer[i][1] = 100;
				}
			}
			
			
			//modern era
			if (WorldData[i] == 26 && WorldTimer[i] > 200 * PopulationMultiplier){
				if(GetSurrounded(i, 25) == true){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldData[i] = 27;
					WorldParticleTimer[i][0] = 1;
					WorldParticleTimer[i][1] = 100;
				}
				else{ PopulationExpand(i); }
			}
			if (WorldData[i] == 27 && WorldTimer[i] > 200 * PopulationMultiplier){
				WorldTimer[i] = -(randomGenerator.nextInt(200));
				WorldData[i] = 28;
				WorldParticleTimer[i][0] = 1;
				WorldParticleTimer[i][1] = 100;
			}
			if (WorldData[i] == 28 && WorldTimer[i] > 200 * PopulationMultiplier){
				WorldTimer[i] = -(randomGenerator.nextInt(200));
				WorldData[i] = 29;
				WorldParticleTimer[i][0] = 1;
				WorldParticleTimer[i][1] = 100;
			}
			if (WorldData[i] == 29 && WorldTimer[i] > 100 * PopulationMultiplier){
				WorldTimer[i] = -(randomGenerator.nextInt(200));
				WorldData[i] = 30;
				WorldParticleTimer[i][0] = 1;
				WorldParticleTimer[i][1] = 100;
			}
			if (WorldData[i] == 30 && WorldTimer[i] > 100 * PopulationMultiplier){
				if (GetSurrounded(i, 26) == true && Age == 3){
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldData[i] = 31;
					WorldParticleTimer[i][0] = 1;
					WorldParticleTimer[i][1] = 100;
				}
				else { PopulationExpand(i); }
				
			}
			
			
			
			if (WorldData[i] > 20){
				WorldTimer[i] += 0.05f;
				if (WorldTimer[i] > 100 * PopulationMultiplier && WorldData[i] < 22){
					WorldData[i] +=1;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldParticleTimer[i][0] = 1;
					WorldParticleTimer[i][1] = 100;
				}
				
				if (WorldTimer[i] > 100 * PopulationMultiplier && WorldData[i] > 21 && Starve == false && WorldData[i] < 26){
					
					PopulationExpand(i);
					
					
					
					if (i> 9 && i < 90 && (i+1)%10 != 0 && i%10 != 0){
						if ((WorldData[i-1] == 17 || WorldData[i-1] > 20) && (WorldData[i+1] == 17 || WorldData[i+1] > 20) && (WorldData[i-10] == 17 || WorldData[i-10] > 20) &&(WorldData[i+10] == 17 || WorldData[i+10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					
					if(i< 90 && i%10 == 0 && i> 9){
						if ((WorldData[i+1] == 17 || WorldData[i+1] > 20) && (WorldData[i+10] == 17 || WorldData[i+10] > 20) && (WorldData[i-10] == 17 || WorldData[i-10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					
					if(i> 9 && (i+1)%10 == 0 && i < 90 ){
						if ((WorldData[i-1] == 17 || WorldData[i-1] > 20) && (WorldData[i+10] == 17 || WorldData[i+10] > 20) && (WorldData[i-10] == 17 || WorldData[i-10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					if (i > 0 && i < 9){
						if ((WorldData[i-1] == 17 || WorldData[i-1] > 20) && (WorldData[i+10] == 17 || WorldData[i+10] > 20) && (WorldData[i+1] == 17 || WorldData[i+1] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					if (i > 90 && i < 99){
						if ((WorldData[i-1] == 17 || WorldData[i-1] > 20) && (WorldData[i-10] == 17 || WorldData[i-10] > 20) && (WorldData[i+1] == 17 || WorldData[i+1] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					if (i == 0){
						if ((WorldData[i+1] == 17 || WorldData[i+1] > 20) && (WorldData[i+10] == 17 || WorldData[i+10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					if (i == 9){
						if ((WorldData[i-1] == 17 || WorldData[i-1] > 20) && (WorldData[i+10] == 17 || WorldData[i+10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					if (i == 90){
						if ((WorldData[i+1] == 17 || WorldData[i+1] > 20) && (WorldData[i-10] == 17 || WorldData[i-10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}
					if (i == 99){
						if ((WorldData[i-1] == 17 || WorldData[i-1] > 20) && (WorldData[i-10] == 17 || WorldData[i-10] > 20)){
							WorldData[i] ++;
							WorldTimer[i] = -(randomGenerator.nextInt(200));
							WorldParticleTimer[i][0] = 1;
							WorldParticleTimer[i][1] = 100;
						}
						else { PopulationExpand(i); }
					}

				}
				/*if (WorldTimer[i] > 100 && WorldData[i] == 23){
					WorldData[i] +=1;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
				}*/
				
				if (WorldData[i] > 22 && Age == 0){
					WorldData[i] = 22;
				}
				if (WorldData[i] > 26 && Age == 1){
					WorldData[i] = 26;
				}
				if (WorldData[i] > 30 && Age == 2){
					WorldData[i] = 30;
				}
				
				
				
			}
			
			
		}
		
		if (OldPopulation < Population){
			
			Faith += Population - OldPopulation;
			
		}
		
		if (OldPopulation > Population){
			
			Faith -=  (OldPopulation - Population) * 2;
			
		}
		
		Faith = 100;
		Age = 4;
	
	}
	
	public static void PopulationExpand(int i){
		
		
		//WorldTimer[i] = -(randomGenerator.nextInt(200));
		Direction = randomGenerator.nextInt(4);
		if (Direction == 0 ){
			if(i> 9){
				if ((WorldData[i-10] != 17 && WorldData[i-10] < 20 && WorldData[i-10] > 11) || (WorldData[i-10] < 3 && WorldData[i-10] > -1) ){
					WorldData[i-10] = 17;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldParticleTimer[i-10][0] = 1;
					WorldParticleTimer[i-10][1] = 100;
				}
			}
		}
		if (Direction == 1 ){
			if(i< 90){
				if ((WorldData[i+10] != 17 && WorldData[i+10] < 20 && WorldData[i+10] > 11) || (WorldData[i+10] < 3 && WorldData[i+10] > -1) ){
					WorldData[i+10] = 17;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldParticleTimer[i+10][0] = 1;
					WorldParticleTimer[i+10][1] = 100;
				}
			}
		}
		if (Direction == 2 ){
			if(i< 99 && (i+1)%10 != 0 ){
				if ((WorldData[i+1] != 17 && WorldData[i+1] < 20 && WorldData[i+1] > 11) || (WorldData[i+1] < 3 && WorldData[i+1] > -1) ){
					WorldData[i+1] = 17;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldParticleTimer[i+1][0] = 1;
					WorldParticleTimer[i+1][1] = 100;
				}
			}
		}
		if (Direction == 3 ){
			if(i> 0 && i%10 != 0 ){
				if ((WorldData[i-1] != 17 && WorldData[i-1] < 20  && WorldData[i-1] > 11) || (WorldData[i-1] < 3 && WorldData[i-1] > -1)){
					WorldData[i-1] = 17;
					WorldTimer[i] = -(randomGenerator.nextInt(200));
					WorldParticleTimer[i-1][0] = 1;
					WorldParticleTimer[i-1][1] = 100;
				}
			}
		}
		WorldTimer[i] = -(randomGenerator.nextInt(200));
		
		
	}
	
	public static void GenerateWorld(){
		
		
		
		for (int i = 0; i <100; i++){
			
			WorldHeight[i] = (float)(randomGenerator.nextInt(9))/10;
			
			WorldData[i] = (randomGenerator.nextInt(20));
			if (WorldData[i] > 17){
				WorldData[i] = -3;
			}
			
			WorldTimer[i] = -(randomGenerator.nextInt(200));
			
			WorldParticleTimer[i][0] = 0;
			WorldParticleTimer[i][1] = 0;
			
			WorldRotate[i] = randomGenerator.nextInt(4);
			
			WorldEffectTimer[i] = 0;
			
			WorldEffect[i] = 0;
			
			TimeOfDay = 0.5f;
			SeaLevel = -0.5f;
			Humidity = 0;
			Faith = 50;
			Pollution = 0;
			Population = 0;
			OldPopulation = 0;
			Food = 300;
			won = false;
			wintimer = 0;
			Quake = 0;
			
		}
		
	}
	
	public static boolean GetSurrounded(int i, int CheckType){
		
		if (i> 9 && i < 90 && (i+1)%10 != 0 && i%10 != 0){
			if (WorldData[i-1] > CheckType && WorldData[i+1] > CheckType &&  WorldData[i-10] > CheckType && WorldData[i+10] > CheckType){
				return true;
			}
		}
		
		if(i< 90 && i%10 == 0 && i> 9){
			if ( WorldData[i+1] > CheckType &&  WorldData[i+10] > CheckType &&  WorldData[i-10] > CheckType){
				return true;
			}
		}
		
		if(i> 9 && (i+1)%10 == 0 && i < 90 ){
			if ( WorldData[i-1] > CheckType && WorldData[i+10] > CheckType && WorldData[i-10] > CheckType){
				return true;
			}
		}
		
		if (i > 0 && i < 9){
			if ( WorldData[i-1] > CheckType &&  WorldData[i+10] > CheckType &&  WorldData[i+1] > CheckType){
				return true;
			}
		}
		
		if (i > 90 && i < 99){
			if ( WorldData[i-1] > CheckType &&  WorldData[i-10] > CheckType && WorldData[i+1] > CheckType){
				return true;
			}
		}
		
		if (i == 0){
			if (WorldData[i+1] > CheckType && WorldData[i+10] > CheckType){
				return true;
			}
		}
		
		if (i == 9){
			if ( WorldData[i-1] > CheckType &&  WorldData[i+10] > CheckType){
				return true;
			}
		}
		
		if (i == 90){
			if (WorldData[i+1] > CheckType && WorldData[i-10] > CheckType){
				return true;
			}
		}
		
		if (i == 99){
			if (WorldData[i-1] > CheckType && WorldData[i-10] > CheckType){
				return true;
			}
		}
		
		return false;
	}
	
	public static void ApplyWeather(int Selected, int Effect){
		
		WorldEffect[Selected] = Effect;
		
		
		if (Selected > 9){
			WorldEffect[Selected - 10] = Effect;
		}
		if (Selected > 19){
			WorldEffect[Selected - 20] = Effect;
		}
		if (Selected < 90){
			WorldEffect[Selected + 10] = Effect;
		}
		if (Selected < 80){
			WorldEffect[Selected + 20] = Effect;
		}
		
		if (Selected%10 != 0){
			WorldEffect[Selected -1] = Effect;
			
			if (Selected > 9){
				WorldEffect[Selected - 11] = Effect;
			}
			if (Selected < 90){
				WorldEffect[Selected + 9] = Effect;
			}

			if ((Selected-1)%10 != 0){
			WorldEffect[Selected -2] = Effect;
			}
		}
		
		if ((Selected+1)%10 != 0){
			WorldEffect[Selected +1] = Effect;
			
			if (Selected > 9){
				WorldEffect[Selected - 9] = Effect;
			}
			if (Selected < 90){
				WorldEffect[Selected + 11] = Effect;
			}
			
			if ((Selected+2)%10 != 0){
			WorldEffect[Selected +2] = Effect;
			}
		}
		
		
		
	}
	
}
