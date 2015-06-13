varying vec3 varyingColour;
varying float Alpha;

void main()
{
	
    gl_FragColor = vec4(varyingColour, Alpha);
}