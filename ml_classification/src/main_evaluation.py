# Import necessary libraries
import pandas as pd
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.pipeline import Pipeline, FeatureUnion
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score


from cbctransformer import CBCTransformer
from plasmatransformer import PlasmaTransformer
from dynamometrytransformer import DynamometryTransformer
from dexatransformer import DEXATransformer


df = pd.read_csv('ml_classification/data/merged-flattened.json')  
X = df.drop('1', axis=1)  
y = df['0']  


X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

feature_union = FeatureUnion([
    ('cbc_transformer', CBCTransformer()),
    ('plasma_transformer', PlasmaTransformer()),
    ('dynamometry_transformer', DynamometryTransformer()),
    ('dexa_transformer', DEXATransformer())
])

preprocessor = ColumnTransformer(
    transformers=[
      
        ('custom', feature_union, X.columns.tolist())
    ]
)


model_pipeline = Pipeline(steps=[
    ('preprocessor', preprocessor),
    ('classifier', RandomForestClassifier(random_state=42))
])


model_pipeline.fit(X_train, y_train)


predictions = model_pipeline.predict(X_test)
print("Model Accuracy:", accuracy_score(y_test, predictions))


param_grid = {
    'classifier__n_estimators': [100, 200],
    'classifier__max_depth': [None, 10, 20],
    
}

grid_search = GridSearchCV(model_pipeline, param_grid, cv=5, scoring='accuracy')
grid_search.fit(X_train, y_train)
print("Best Grid Search Score:", grid_search.best_score_)
print("Best Grid Search Parameters:", grid_search.best_params_)
