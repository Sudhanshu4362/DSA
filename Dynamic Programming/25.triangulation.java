// BASED ON CATALAN
//  you are given convex polygon return no ways to triangulate it i.e divide it into triangles.s.t diagonal never 
// intersect

/* Approach:
for triangle = 1  = p(3) = c1
for quadrialateral -> only 2 ways c0c1 + c1c0 => p(4) = c2
for pentagon -> 5 ways 

so p(n) = c(n-2) 
*/