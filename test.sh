#!/usr/bin/env bash
set -euo pipefail
cd -- "$(dirname -- "${BASH_SOURCE[0]}")"
bash ./build.sh
OOP_JAVA="java"
if [[ -n "${JAVA_HOME:-}" ]]; then
    OOP_JAVA="$JAVA_HOME/bin/java"
fi
mkdir -p build/test-classes
"$OOP_JAVA" -m jdk.compiler/com.sun.tools.javac.Main \
    --release 17 -encoding UTF-8 -Xlint:all -Werror \
    -cp build/classes -d build/test-classes tests/report/ReconstructionTest.java
"$OOP_JAVA" -cp build/classes:build/test-classes report.ReconstructionTest
