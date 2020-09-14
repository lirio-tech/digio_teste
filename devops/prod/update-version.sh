

SNAPSHOT="SNAPSHOT"
NEW_VERSION=$(cat pom.xml | grep "^    <version>.*</version>$" | awk -F'[><]' '{print $3}')

case "$NEW_VERSION" in
    *$SNAPSHOT* ) echo "Version OK";;
    * ) echo "Error... version should to be $SNAPSHOT";;
esac

NEW_VERSION_RELEASE=$(echo $NEW_VERSION | sed -e "s/$SNAPSHOT/RELEASE/g")

mvn --batch-mode release:update-versions -DdevelopmentVersion=$NEW_VERSION_RELEASE
sed -i "s/REPLACE_VERSION/$NEW_VERSION_RELEASE/g" devops/prod/digio-kubernetes-deployment-v2.yml 
