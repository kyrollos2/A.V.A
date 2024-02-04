class DEXATransformer(BaseEstimator, TransformerMixin):
    def fit(self, X, y=None):
        return self  # No fitting necessary

    def transform(self, X):
        X = X.copy()  # Work on a copy to avoid changing the original data
        # DEXA T-score interpretations
        X['DEXA_LowBoneDensity'] = X['DEXA_TScore'].between(-1, -2.5)
        X['DEXA_Osteoporosis'] = X['DEXA_TScore'] <= -2.5

        return X
