import org.checkerframework.checker.dividebyzero.qual.*;

// Test subtyping relationships for the Divide By Zero Checker.
// The file contains "// ::" comments to indicate expected errors and warnings.

class SubtypeTest {
  // You will want a test like this for every pair of qualifiers in your type hierarchy.
  void oneSubtypingRelationship(@PossiblyZero Integer x, @Bottom Integer y) {
    @PossiblyZero Integer a = x;
    @PossiblyZero Integer b = y;
    // :: error: assignment
    @Bottom Integer c = x; // expected error on this line, as indicated just above
    @Bottom Integer d = y;
  }

  void anotherSubtypingRelationship(@PossiblyZero Integer x, @Zero Integer y) {
    @PossiblyZero Integer a = x;
    @PossiblyZero Integer b = y;
    // :: error: assignment
    @Zero Integer c = x; // expected error on this line, as indicated just above
    @Zero Integer d = y;
  }

  void thisSubtypingRelationship(@PossiblyZero Integer x, @NonZero Integer y) {
    @PossiblyZero Integer a = x;
    @PossiblyZero Integer b = y;
    // :: error: assignment
    @NonZero Integer c = x; // expected error on this line, as indicated just above
    @NonZero Integer d = y;
  }
  
  /////////////// ////////////// /////////////// //////////////
  // Now, test the same subtyping relationships, but with the @Zero qualifier instead
  void oneSubtypingRelationship2(@Zero Integer x, @Bottom Integer y) {
    @Zero Integer a = x;
    @Zero Integer b = y;
    // :: error: assignment
    @Bottom Integer c = x; // expected error on this line, as indicated just above
    @Bottom Integer d = y;
  }

  void anotherSubtypingRelationship2(@Zero Integer x, @PossiblyZero Integer y) {
    @Zero Integer a = x;
    // :: error: assignment
    @Zero Integer b = y; // expected error on this line, as indicated just above
    @PossiblyZero Integer c = x;
    @PossiblyZero Integer d = y;
  }

  void thisSubtypingRelationship2(@Zero Integer x, @NonZero Integer y) {
    @Zero Integer a = x;
    // :: error: assignment
    @Zero Integer b = y; // expected error on this line, as indicated just above
    // :: error: assignment
    @NonZero Integer c = x; // expected error on this line, as indicated just above
    @NonZero Integer d = y;
  }

  /////////////// ////////////// /////////////// //////////////
  // Now, test the same subtyping relationships, but with the @NonZero qualifier instead
  void oneSubtypingRelationship3(@NonZero Integer x, @Bottom Integer y) {
    @NonZero Integer a = x;
    @NonZero Integer b = y;
    // :: error: assignment
    @Bottom Integer c = x; // expected error on this line, as indicated just above
    @Bottom Integer d = y;
  }

  void anotherSubtypingRelationship3(@NonZero Integer x, @PossiblyZero Integer y) {
    @NonZero Integer a = x;
    // :: error: assignment
    @NonZero Integer b = y; // expected error on this line, as indicated just above
    @PossiblyZero Integer c = x;
    @PossiblyZero Integer d = y;
  }

  void thisSubtypingRelationship3(@NonZero Integer x, @Zero Integer y) {
    @NonZero Integer a = x;
    // :: error: assignment
    @NonZero Integer b = y; // expected error on this line, as indicated just above
    // :: error: assignment
    @Zero Integer c = x; // expected error on this line, as indicated just above
    @Zero Integer d = y;
  }

  /////////////// ////////////// /////////////// //////////////
  // Now, test the same subtyping relationships, but with the @Bottom qualifier instead
  void oneSubtypingRelationship4(@Bottom Integer x, @NonZero Integer y) {
    @Bottom Integer a = x;
    // :: error: assignment
    @Bottom Integer b = y; // expected error on this line, as indicated just above
    @NonZero Integer c = x;
    @NonZero Integer d = y;
  }

  void anotherSubtypingRelationship4(@Bottom Integer x, @PossiblyZero Integer y) {
    @Bottom Integer a = x;
    // :: error: assignment
    @Bottom Integer b = y; // expected error on this line, as indicated just above
    @PossiblyZero Integer c = x;
    @PossiblyZero Integer d = y;
  }

  void thisSubtypingRelationship4(@Bottom Integer x, @Zero Integer y) {
    @Bottom Integer a = x;
    // :: error: assignment
    @Bottom Integer b = y; // expected error on this line, as indicated just above
    @Zero Integer c = x;
    @Zero Integer d = y;
  }


}
