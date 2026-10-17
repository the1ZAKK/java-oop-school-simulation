#!/usr/bin/env bash
set -euo pipefail
cd -- "$(dirname -- "${BASH_SOURCE[0]}")"
bash ./build.sh
OOP_JAVA="java"
if [[ -n "${JAVA_HOME:-}" ]]; then
    OOP_JAVA="$JAVA_HOME/bin/java"
fi
exec "$OOP_JAVA" -cp build/classes report.TEST
