package MyPackage;


import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.glu.GLU;
//import org.lwjgl.opengl.glu.GLU;
import org.lwjgl.input.Keyboard;



 
public class Main {
    private boolean done = false;
    private boolean fullscreen = false;
    private final String windowTitle = "Moe's World Game";
    private boolean f1 = false;
    private DisplayMode displayMode;
    
    
    
    
    
    
    float rotation = 0.0f;
    int Temp = 0;
    long time;
    long temptime;
    long tempdrawtime;

    /**
     * Everything starts and ends here.  Takes 1 optional command line argument.
     * If fullscreen is specified on the command line then fullscreen is used,
     * otherwise windowed mode will be used.
     * @param args command line arguments
     */
    public static void main(String args[]) {
        boolean fullscreen = false;
        if(args.length>0) {
            if(args[0].equalsIgnoreCase("fullscreen")) {
                fullscreen = true;
            }
        }
        Main l1 = new Main();
        l1.run(fullscreen);
    }

    /**
     * Launch point
     * @param fullscreen boolean value, set to true to run in fullscreen mode
     */
    public void run(boolean fullscreen) {
        this.fullscreen = fullscreen;
        try {
            init();					//INITALISE AREA
            
            Particle.LoadTextures();
            World.GenerateWorld();
            
            while (!done) {
            	
            	
            	
                mainloop();
                render();
                
                
                
                update();
                
                
                
                Display.update();
                Display.sync(120);

                
                
            }
            cleanup();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * All updating is done here.  Key and mouse polling as well as window closing and
     * custom updates, such as AI.
     */
    private void mainloop() {
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {       // Exit if Escape is pressed
            done = true;
        }
        if(Display.isCloseRequested()) {                     // Exit if window is closed
            done = true;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_F1) && !f1) {    // Is F1 Being Pressed?
            f1 = true;                                      // Tell Program F1 Is Being Held
            switchMode();                                   // Toggle Fullscreen / Windowed Mode
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F1)) {          // Is F1 Being Pressed?
            f1 = false;
        }
    }

    private void switchMode() {
        fullscreen = !fullscreen;
        try {
            Display.setFullscreen(fullscreen);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * For rendering all objects to the screen
     * @return boolean for success or not
     */
    private boolean render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);          // Clear The Screen And The Depth Buffer
        GL11.glLoadIdentity();                          // Reset The Current Modelview Matrix
      
        
        
        ///DRAW SHIT HERE

        World.DrawWorld();
        World.ParticleDraw();
        World.UIDraw();
                               
        
        
        return true;
        
        
    }

    /**
     * Create a window depending on whether fullscreen is selected
     * @throws Exception Throws the Window.create() exception up the stack.
     */
    private void createWindow() throws Exception {
        Display.setFullscreen(fullscreen);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 1920
                && d[i].getHeight() == 1080
                && d[i].getBitsPerPixel() == 32) {
                displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(displayMode);
        Display.setTitle(windowTitle);
        Display.create();
        Display.setResizable(true);
        Display.setFullscreen(true);
    }

    /**
     * Do all initilization code here.  Including Keyboard and OpenGL
     * @throws Exception Passes any exceptions up to the main loop to be handled
     */
    private void init() throws Exception {
        createWindow();

        initGL();
        MyFont.buildFont();

    }

    /**
     * Initialize OpenGL
     *
     */
    private void initGL() {
        GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
        GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glClearColor(0.52f, 0.81f, 0.92f, 0.0f); // Background
        GL11.glClearDepth(1.0); // Depth Buffer Setup
        GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
        GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do

        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        
       
        GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping 
        

    	GL11.glEnable(GL11.GL_LIGHT1); 
    	GL11.glEnable ( GL11.GL_LIGHTING );

        GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
        GL11.glLoadIdentity(); // Reset The Projection Matrix

        // Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(
          45.0f,
          (float) displayMode.getWidth() / (float) displayMode.getHeight(),
          0.1f,
          100.0f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix

        // Really Nice Perspective Calculations
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
    }

    
    private void cleanup() {
        Display.destroy();
    }
    
    
    
    private void update(){
    	
    	rotation += 0.1f;
    	World.WorldUpdate();
    	
    }
    
    
    /*
    
    
    private void glPrint(String msg) {                                      // Custom GL "Print" Routine
    	
    	GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping 
    	
        if(msg != null) {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
            for(int i=0;i<msg.length();i++) {
                GL11.glCallList(base + msg.charAt(i));
                GL11.glTranslatef(0.05f, 0.0f, 0.0f);
            }
        }
        
        GL11.glDisable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping 
    }

    
    
    */
  
    

    
    

}




