#!/usr/bin/env bash
set -euo pipefail
cd -- "$(dirname -- "${BASH_SOURCE[0]}")"

OOP_JAVA="java"
if [[ -n "${JAVA_HOME:-}" ]]; then
    OOP_JAVA="$JAVA_HOME/bin/java"
fi

if ! "$OOP_JAVA" -m jdk.compiler/com.sun.tools.javac.Main -version >/dev/null 2>&1; then
    printf '%s\n' 'A full JDK 17 or later is required. Set JAVA_HOME or put its bin directory on PATH.' >&2
    exit 1
fi

rm -rf -- build/classes build/test-classes
mkdir -p build/classes
"$OOP_JAVA" -m jdk.compiler/com.sun.tools.javac.Main \
    --release 17 -encoding UTF-8 -Xlint:all -Werror \
    -d build/classes @config/sources.txt
"$OOP_JAVA" -m jdk.jartool/sun.tools.jar.Main --create \
    --file build/java-oop-school-simulation.jar --main-class report.TEST \
    -C build/classes .
printf '%s\n' 'Build complete: build/java-oop-school-simulation.jar'
