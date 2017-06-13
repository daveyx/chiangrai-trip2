import React from 'react';
import { IndexLink, Link } from 'react-router';

export default class Test extends React.Component {
	
	render() {
		return (
			<div>
				<IndexLink to="/">Home Index Link</IndexLink>
				<br />
				<Link to="/">Home Link</Link>
				<br />
				<IndexLink to="/test">test Index Link</IndexLink>
				<br />
				<Link to="/test">test Link</Link>
				<br />
				<p>This is a test</p>
			</div>
		)
	}
}